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


        List<Customer_Details> customerDetailsList = new ArrayList<>();
        List<Account_Records> accountRecordsList = new ArrayList<>();
        List<Transaction_Details> transactionDetailsList = new ArrayList<>();
        List<Fraud_Details> fraudDetailsList = new ArrayList<>();
        List<CreditScore_Details> creditScoreDetailsList = new ArrayList<>();
        List<Kyc_Records> kycRecordsList  = new ArrayList<>();


        Map<String, FileHandler<?>> fileHandler = new HashMap<>();
        fileHandler.put("customer.txt", new FileHandler<>(customerDetailsList, Customer_Details.class));
        fileHandler.put("account.txt", new FileHandler<>(accountRecordsList, Account_Records.class));
        fileHandler.put("fraud.txt", new FileHandler<>(fraudDetailsList, Fraud_Details.class));
        fileHandler.put("creditScore.txt", new FileHandler<>(creditScoreDetailsList, CreditScore_Details.class));
        fileHandler.put("transaction.txt", new FileHandler<>(transactionDetailsList, Transaction_Details.class));
        fileHandler.put("kycFile.txt", new FileHandler<>(kycRecordsList, Kyc_Records.class));


        File controlFolder = new File("Control");
        File[] dateFolders = controlFolder.listFiles();
        if (dateFolders != null) {
            for (File dateFolder : dateFolders) {
                File[] files = dateFolder.listFiles();
                if (files != null) {
                    for (File file : files) {
                        String fileName = file.getName();
                        if (fileHandler.containsKey(fileName)) {
                            FileHandler<?> handler = fileHandler.get(fileName);
                            readDetails(file, handler);
                        }
                    }
                }
            }
        }
        System.out.println(customerDetailsList);
        System.out.println(accountRecordsList);
        System.out.println(fraudDetailsList);
        System.out.println(creditScoreDetailsList);
        System.out.println(transactionDetailsList);
        System.out.println(kycRecordsList);

    }




    static class FileHandler<T>
    {
        List<T> list;
        Class<T> clazz;

        FileHandler(List<T> list, Class<T> clazz)
        {
            this.list = list;
            this.clazz = clazz;
        }
    }




     static <T> void readDetails(File file,FileHandler<T> handler)
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


                T details = parseLineToRecord(line, handler.clazz);
                handler.list.add(details);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
//                System.out.println(parsedValue);
            }
            else if(component.getType() == short.class)
            {
                parsedValue = Short.parseShort(value);
//                System.out.println(parsedValue);
            }
            else if(component.getType() == boolean.class)
            {
                parsedValue = Boolean.parseBoolean(value);
//                System.out.println(parsedValue);
            }
            else if(component.getType() == double.class)
            {
                parsedValue = Double.parseDouble(value);
//                System.out.println(parsedValue);
            }
            else if (component.getType() == long.class) {
                parsedValue = Long.parseLong(value);
//                System.out.println(parsedValue);
            }
            else if (component.getType() == LocalDate.class) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                parsedValue = LocalDate.parse(value, formatter);
//                System.out.println(parsedValue);
            }
            else if (component.getType() == LocalTime.class) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                parsedValue = LocalTime.parse(value, formatter);
//                System.out.println(parsedValue);
            }
            else if (component.getType() == LocalDateTime.class) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                parsedValue = LocalDateTime.parse(value, formatter);
//                System.out.println(parsedValue);
            }
            else {
                parsedValue = value;
//                System.out.println(parsedValue);
            }
            parsedValues.add(parsedValue);
        }

        Constructor<T> constructor = recordClass.getDeclaredConstructor(
                Arrays.stream(components).map(RecordComponent::getType).toArray(Class<?>[]::new)
        );
//        System.out.println(constructor.newInstance(parsedValues.toArray()));
//        System.out.println(parsedValues);
        return constructor.newInstance(parsedValues.toArray());

    }
}