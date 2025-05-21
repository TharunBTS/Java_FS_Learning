package FileToPOJO;

import Annotation.FieldLength;
import model.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.RecordComponent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Modules {




    public void toPojo() {


        List<Customer> Customer = new ArrayList<>();
        List<Account> Account = new ArrayList<>();
        List<Transaction> Transaction = new ArrayList<>();
        List<Fraud> Fraud = new ArrayList<>();
        List<CreditScore> CreditScore = new ArrayList<>();
        List<Kyc> Kyc  = new ArrayList<>();


//        Map<String, FileHandler<?>> fileHandler = new HashMap<>();
//        fileHandler.put("customer.txt", new FileHandler<>(customerDetailsList, Customer_D.class));
//        fileHandler.put("account.txt", new FileHandler<>(accountRecordsList, Account.class));
//        fileHandler.put("fraud.txt", new FileHandler<>(fraudDetailsList, Fraud_Details.class));
//        fileHandler.put("creditScore.txt", new FileHandler<>(creditScoreDetailsList, CreditScore_Details.class));
//        fileHandler.put("transaction.txt", new FileHandler<>(transactionDetailsList, Transaction_Details.class));
//        fileHandler.put("kycFile.txt", new FileHandler<>(kycRecordsList, Kyc_Records.class));



        Map<String , List<?>> listMap = new HashMap<>();
        listMap.put("Account", Account);
        listMap.put("Customer", Customer);
        listMap.put("CreditScore", CreditScore);
        listMap.put("Fraud", Fraud);
        listMap.put("Kyc", Kyc);
//        listMap.put("Account", new ArrayList<Account>());


        File controlFolder = new File("Control");
        File[] dateFolders = controlFolder.listFiles();
        if (dateFolders != null) {
            for (File dateFolder : dateFolders) {
                File[] files = dateFolder.listFiles();
                if (files != null) {
                    for (File file : files) {
                        try
                        {
                            String fileName = file.getName();
                            String className = fileName.replace(".txt","");
                            String fullClassName = "model."+ className;
                            String baseName = className.replaceAll("\\d+$", "");
                            System.out.println("class full name : "+baseName);
                            Class<?> clazz = Class.forName(baseName);
                            List<?> list = listMap.get(baseName);
                            if(list == null ) System.out.println(" no list found for key "+baseName);
//                            FileHandler<?> handler = fileHandler.get(className);
//                            listMap.putIfAbsent(className, new ArrayList<>());
//                            List<Object> list = listMap.get(className);
                            readRawDetails(file,clazz,list);
                        }catch(Exception e)
                        {
                            System.out.println(e.getMessage());
                        }

//                        if (fileHandler.containsKey(fileName)) {
//                            FileHandler<?> handler = fileHandler.get(fileName);
//                            readDetails(file, handler);
//                        }

                    }
                }
            }
        }
        System.out.println(Customer);
        System.out.println(Fraud);
        System.out.println(Account);
        System.out.println(CreditScore);
        System.out.println(Transaction);
        System.out.println(Kyc);



    }


    @SuppressWarnings("unchecked")
   private <T> void readRawDetails(File file, Class<?> rawClass, List<?> rawList)
   {
       if(rawClass == null)
       {
           System.out.println("raw class is null");
       }
       if(rawList == null)
       {
           System.out.println("raw list is null");
       }
       readDetails(file,(Class<T>) rawClass,(List<T>) rawList);
   }

//    static class FileHandler<T>
//    {
//        List<T> list;
//        Class<T> clazz;
//
//        FileHandler(List<T> list, Class<T> clazz)
//        {
//            this.list = list;
//            this.clazz = clazz;
//        }
//    }




     static <T> void readDetails(File file,Class<T> className,List<T> list)
    {
        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int lineNumber = 0;
            int totalLines = (int) br.lines().count();

            br.close();


            br = new BufferedReader(new FileReader(file));

            while ((line = br.readLine()) != null) {


                lineNumber++;
                if (lineNumber == 1 || lineNumber == totalLines) {
                continue;
                 }


                T details = parseLineToRecord(line, className);
                list.add(details);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    public static <T> T parseLineToRecord(String line, Class<T> recordClass) throws Exception {
        RecordComponent[] components = recordClass.getRecordComponents();
        List<Object> parsedValues = new ArrayList<>();
        int index = 0;

        for (RecordComponent component : components) {
            FieldLength annotation = component.getAnnotation(FieldLength.class);
            if (annotation == null) continue;

            int length = annotation.value();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length && index < line.length(); i++, index++) {
                sb.append(line.charAt(index));
            }

            String value = sb.toString().trim();
            Object parsedValue;

            if(component.getType() == int.class)
            {
                parsedValue = Integer.parseInt(value);

            }
            else if(component.getType() == float.class)
            {
                parsedValue = Float.parseFloat(value);

            }
            else if(component.getType() == short.class)
            {
                parsedValue = Short.parseShort(value);

            }
            else if(component.getType() == boolean.class)
            {
                parsedValue = Boolean.parseBoolean(value);

            }
            else if(component.getType() == double.class)
            {
                parsedValue = Double.parseDouble(value);

            }
            else if (component.getType() == long.class) {
                parsedValue = Long.parseLong(value);

            }
            else if (component.getType() == LocalDate.class) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                parsedValue = LocalDate.parse(value, formatter);

            }
            else if (component.getType() == LocalTime.class) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                parsedValue = LocalTime.parse(value, formatter);
            }
            else if (component.getType() == LocalDateTime.class) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                parsedValue = LocalDateTime.parse(value, formatter);
            }
            else {
                parsedValue = value;
            }
            parsedValues.add(parsedValue);
        }

        Constructor<T> constructor = recordClass.getDeclaredConstructor(
                Arrays.stream(components).map(RecordComponent::getType).toArray(Class<?>[]::new)
        );

        return constructor.newInstance(parsedValues.toArray());

    }
}