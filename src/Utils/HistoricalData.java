/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Business.Models.Crop;
import Business.Models.CropSalesRelation;
import Business.Models.Sales;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.bson.Document;

/**
 *
 * @author kpraneeth
 */
public class HistoricalData {

    public static ArrayList<CropSalesRelation> marketBasedData;
    public static HashMap<String, CropSalesRelation> seasonBasedData;
//    public static HashMap<Integer, HashMap<String, Integer>> marketData = new HashMap();
    public static HashMap<Integer, ArrayList<CropSalesRelation>> futureMarketData = new HashMap();
//    public static HashMap<String, HashMap<String, Integer>> seasonData = new HashMap();
    public static HashMap<String, ArrayList<CropSalesRelation>> futureSeasonData = new HashMap();
    public static HashMap<Integer, ArrayList<CropSalesRelation>> marketData = new HashMap<>();
    public static HashMap<String, ArrayList<CropSalesRelation>> seasonData = new HashMap<>();
    // Define a list of types
    public static List<String> types = Arrays.asList("Grain", "Vegetable", "Fruit");
    public static List<Crop> plannedCrops= new ArrayList<>();

    public static void generateMarketnSeasonBasedData() {

        Crop crop1 = new Crop();
        crop1.setName("Wheat");
        crop1.setType("Grain");
        crop1.setSeason("Winter");
        crop1.setCharacteristics(new ArrayList<>());
        crop1.getCharacteristics().add("High yield");
        crop1.getCharacteristics().add("Drought-resistant");

        Crop crop2 = new Crop();
        crop2.setName("Tomato");
        crop2.setType("Vegetable");
        crop2.setSeason("Summer");
        crop2.setCharacteristics(new ArrayList<>());
        crop2.getCharacteristics().add("Rich in vitamins");
        crop2.getCharacteristics().add("Warm weather");

        // Creating Sales objects and setting data using setters
        Sales sales1 = new Sales();
        sales1.setQuantity(100);

        Sales sales2 = new Sales();
        sales2.setQuantity(50);

        // Creating CropSalesRelation objects and populating marketBasedData
        marketBasedData = new ArrayList<>();
        marketBasedData.add(new CropSalesRelation(crop1, sales1));
        marketBasedData.add(new CropSalesRelation(crop2, sales2));

        // Populating seasonBasedData
        seasonBasedData = new HashMap<>();
        seasonBasedData.put(crop1.getSeason(), new CropSalesRelation(crop1, sales1));
        seasonBasedData.put(crop2.getSeason(), new CropSalesRelation(crop2, sales2));

        Crop crop3 = new Crop();
        crop3.setName("Corn");
        crop3.setType("Grain");
        crop3.setSeason("Summer");
        crop3.setCharacteristics(new ArrayList<>());
        crop3.getCharacteristics().add("Requires full sun");
        crop3.getCharacteristics().add("Warm temperatures");

        // Creating Sales objects and setting data using setters
        Sales sales3 = new Sales();
        sales3.setQuantity(120);

        // Creating CropSalesRelation objects and adding to marketBasedData
        marketBasedData.add(new CropSalesRelation(crop3, sales3));

        // Adding to seasonBasedData
        seasonBasedData.put(crop3.getSeason(), new CropSalesRelation(crop3, sales3));

        // Creating another set of Crop and Sales objects
        Crop crop4 = new Crop();
        crop4.setName("Lettuce");
        crop4.setType("Vegetable");
        crop4.setSeason("Spring");
        crop4.setCharacteristics(new ArrayList<>());
        crop4.getCharacteristics().add("Cool weather crop");
        crop4.getCharacteristics().add("Rich in nutrients");

        Sales sales4 = new Sales();
        sales4.setQuantity(90);

        // Adding to marketBasedData
        marketBasedData.add(new CropSalesRelation(crop4, sales4));

        // Adding to seasonBasedData
        seasonBasedData.put(crop4.getSeason(), new CropSalesRelation(crop4, sales4));

        // Creating another set of Crop and Sales objects
        Crop crop5 = new Crop();
        crop5.setName("Rice");
        crop5.setType("Grain");
        crop5.setSeason("Monsoon");
        crop5.setCharacteristics(new ArrayList<>());
        crop5.getCharacteristics().add("Requires standing water");
        crop5.getCharacteristics().add("High humidity");

        Sales sales5 = new Sales();
        sales5.setQuantity(150);

        // Adding to marketBasedData
        marketBasedData.add(new CropSalesRelation(crop5, sales5));

        // Adding to seasonBasedData
        seasonBasedData.put(crop5.getSeason(), new CropSalesRelation(crop5, sales5));

        Crop crop6 = new Crop();
        crop6.setName("Potato");
        crop6.setType("Tuber");
        crop6.setSeason("Autumn");
        crop6.setCharacteristics(new ArrayList<>());
        crop6.getCharacteristics().add("Grows underground");
        crop6.getCharacteristics().add("Starchy vegetable");

        // Creating Sales objects and setting data using setters
        Sales sales6 = new Sales();
        sales6.setQuantity(80);

        // Creating CropSalesRelation objects and adding to marketBasedData
        marketBasedData.add(new CropSalesRelation(crop6, sales6));

        // Adding to seasonBasedData
        seasonBasedData.put(crop6.getSeason(), new CropSalesRelation(crop6, sales6));

        // Creating another set of Crop and Sales objects
        Crop crop7 = new Crop();
        crop7.setName("Cucumber");
        crop7.setType("Vegetable");
        crop7.setSeason("Summer");
        crop7.setCharacteristics(new ArrayList<>());
        crop7.getCharacteristics().add("High water content");
        crop7.getCharacteristics().add("Vining plant");

        Sales sales7 = new Sales();
        sales7.setQuantity(110);

        // Adding to marketBasedData
        marketBasedData.add(new CropSalesRelation(crop7, sales7));

        // Adding to seasonBasedData
        seasonBasedData.put(crop7.getSeason(), new CropSalesRelation(crop7, sales7));

        // Creating another set of Crop and Sales objects
        Crop crop8 = new Crop();
        crop8.setName("Strawberry");
        crop8.setType("Berry");
        crop8.setSeason("Spring");
        crop8.setCharacteristics(new ArrayList<>());
        crop8.getCharacteristics().add("Low in calories");
        crop8.getCharacteristics().add("Rich in antioxidants");

        Sales sales8 = new Sales();
        sales8.setQuantity(60);

        // Adding to marketBasedData
        marketBasedData.add(new CropSalesRelation(crop8, sales8));

        // Adding to seasonBasedData
        seasonBasedData.put(crop8.getSeason(), new CropSalesRelation(crop8, sales8));

        Crop crop9 = new Crop();
        crop9.setName("Carrot");
        crop9.setType("Root Vegetable");
        crop9.setSeason("Winter");
        crop9.setCharacteristics(new ArrayList<>());
        crop9.getCharacteristics().add("Rich in beta-carotene");
        crop9.getCharacteristics().add("Good for eyesight");

        // Creating Sales objects and setting data using setters
        Sales sales9 = new Sales();
        sales9.setQuantity(95);

        // Creating CropSalesRelation objects and adding to marketBasedData
        marketBasedData.add(new CropSalesRelation(crop9, sales9));

        // Adding to seasonBasedData
        seasonBasedData.put(crop9.getSeason(), new CropSalesRelation(crop9, sales9));

        // Creating another set of Crop and Sales objects
        Crop crop10 = new Crop();
        crop10.setName("Spinach");
        crop10.setType("Leafy Green");
        crop10.setSeason("Spring");
        crop10.setCharacteristics(new ArrayList<>());
        crop10.getCharacteristics().add("High in iron");
        crop10.getCharacteristics().add("Cool-season crop");

        Sales sales10 = new Sales();
        sales10.setQuantity(120);

        // Adding to marketBasedData
        marketBasedData.add(new CropSalesRelation(crop10, sales10));

        // Adding to seasonBasedData
        seasonBasedData.put(crop10.getSeason(), new CropSalesRelation(crop10, sales10));

        // Creating another set of Crop and Sales objects
        Crop crop11 = new Crop();
        crop11.setName("Orange");
        crop11.setType("Citrus Fruit");
        crop11.setSeason("Summer");
        crop11.setCharacteristics(new ArrayList<>());
        crop11.getCharacteristics().add("Rich in vitamin C");
        crop11.getCharacteristics().add("Sweet and juicy");

        Sales sales11 = new Sales();
        sales11.setQuantity(80);

        // Adding to marketBasedData
        marketBasedData.add(new CropSalesRelation(crop11, sales11));

        // Adding to seasonBasedData
        seasonBasedData.put(crop11.getSeason(), new CropSalesRelation(crop11, sales11));

        Crop crop12 = new Crop();
        crop12.setName("Broccoli");
        crop12.setType("Cruciferous Vegetable");
        crop12.setSeason("Autumn");
        crop12.setCharacteristics(new ArrayList<>());
        crop12.getCharacteristics().add("Rich in vitamins K and C");
        crop12.getCharacteristics().add("Cool-weather crop");

        // Creating Sales objects and setting data using setters
        Sales sales12 = new Sales();
        sales12.setQuantity(70);

        // Creating CropSalesRelation objects and adding to marketBasedData
        marketBasedData.add(new CropSalesRelation(crop12, sales12));

        // Adding to seasonBasedData
        seasonBasedData.put(crop12.getSeason(), new CropSalesRelation(crop12, sales12));

        // Creating another set of Crop and Sales objects
        Crop crop13 = new Crop();
        crop13.setName("Avocado");
        crop13.setType("Fruit");
        crop13.setSeason("Summer");
        crop13.setCharacteristics(new ArrayList<>());
        crop13.getCharacteristics().add("Healthy monounsaturated fats");
        crop13.getCharacteristics().add("Creamy texture");

        Sales sales13 = new Sales();
        sales13.setQuantity(110);

        // Adding to marketBasedData
        marketBasedData.add(new CropSalesRelation(crop13, sales13));

        // Adding to seasonBasedData
        seasonBasedData.put(crop13.getSeason(), new CropSalesRelation(crop13, sales13));

        // Creating another set of Crop and Sales objects
        Crop crop14 = new Crop();
        crop14.setName("Blueberries");
        crop14.setType("Berry");
        crop14.setSeason("Spring");
        crop14.setCharacteristics(new ArrayList<>());
        crop14.getCharacteristics().add("Rich in antioxidants");
        crop14.getCharacteristics().add("Low in calories");

        Sales sales14 = new Sales();
        sales14.setQuantity(90);

        // Adding to marketBasedData
        marketBasedData.add(new CropSalesRelation(crop14, sales14));

        // Adding to seasonBasedData
        seasonBasedData.put(crop14.getSeason(), new CropSalesRelation(crop14, sales14));

        Crop crop15 = new Crop();
        crop15.setName("Pumpkin");
        crop15.setType("Squash");
        crop15.setSeason("Autumn");
        crop15.setCharacteristics(new ArrayList<>());
        crop15.getCharacteristics().add("Used in cooking and decorations");
        crop15.getCharacteristics().add("Requires ample space to grow");

        // Creating Sales object and setting data using setters
        Sales sales15 = new Sales();
        sales15.setQuantity(60);

        // Creating CropSalesRelation object and adding to marketBasedData
        marketBasedData.add(new CropSalesRelation(crop15, sales15));

        // Adding to seasonBasedData
        seasonBasedData.put(crop15.getSeason(), new CropSalesRelation(crop15, sales15));
        
        System.out.println("Market Based: "+marketBasedData);
        System.out.println("Season Based: "+seasonBasedData);
//
//        plannedCrops.add(crop1);
//        plannedCrops.add(crop1);
//        plannedCrops.add(crop5);
//        plannedCrops.add(crop7);
//        plannedCrops.add(crop11);
//        plannedCrops.add(crop5);
//        plannedCrops.add(crop7);
//        plannedCrops.add(crop11);
    }
    
    public static void generateMarketBasedDatafromJSON() {
         try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {
            // Specify the database and collection
            MongoDatabase database = mongoClient.getDatabase("local");
            MongoCollection<Document> collection = database.getCollection("users");

            // Retrieve the document from MongoDB
            Document document = collection.find().first();

            // Parse the document into CropSalesRelation objects
            marketBasedData = parseDocumentToCropSalesRelationList(document);

            // Print the marketBasedData
            for (CropSalesRelation relation : marketBasedData) {
                System.out.println("Crop: " + relation.getCrop().getName() + ", Sales Quantity: " + relation.getSales().getQuantity());
            }
        }

    }
    
     public static void generateSeasonBasedDatafromJSON() {
          try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {
            // Specify the database and collection
            MongoDatabase database = mongoClient.getDatabase("local");
            MongoCollection<Document> collection = database.getCollection("users");

            // Retrieve the document from MongoDB
             FindIterable<Document> documents = collection.find();

            // Choose the desired document
            Document document = getDesiredDocument(documents);

            // Parse the document into seasonBasedData HashMap
            seasonBasedData = parseDocumentToSeasonBasedDataMap(document);

            // Print the seasonBasedData
            for (String season : seasonBasedData.keySet()) {
                CropSalesRelation relation = seasonBasedData.get(season);
                System.out.println("Season: " + season + ", Crop: " + relation.getCrop().getName() +
                        ", Sales Quantity: " + relation.getSales().getQuantity());
            }
        }
     }

//    public static void generatePreviousYearsMarketData() {
//        List<String> cropNames = new ArrayList<>(Arrays.asList(
//                "Wheat", "Tomato", "Corn", "Lettuce", "Rice",
//                "Potato", "Cucumber", "Strawberry", "Carrot", "Spinach",
//                "Orange", "Broccoli", "Avocado", "Blueberries", "Pumpkin"));
//
//        // List of seasons
//        List<String> seasons = new ArrayList<>(Arrays.asList("Winter", "Summer", "Spring", "Autumn", "Monsoon"));
//
//        // Creating marketData HashMap
//        // HashMap<Integer, HashMap<String, Integer>> marketData = new HashMap<>();
//
//        // Creating seasonData HashMap
//        // HashMap<String, HashMap<String, Integer>> seasonData = new HashMap<>();
//
//        // Filling marketData with random data for each crop and each year
//        for (int year = 2018; year <= 2022; year++) {
//            HashMap<String, Integer> cropQuantityMap = new HashMap<>();
//
//            for (String crop : cropNames) {
//                int randomQuantity = getRandomQuantity();
//                cropQuantityMap.put(crop, randomQuantity);
//            }
//
//            marketData.put(year, cropQuantityMap);
//        }
//
//        // Print marketData
//        System.out.println("Market Data: " + marketData);
//
//        // Populating seasonData based on marketData
//        for (int year : marketData.keySet()) {
//            HashMap<String, Integer> cropQuantityMap = marketData.get(year);
//
//            for (String season : seasons) {
//                // Create a HashMap for each season if not present
//                seasonData.computeIfAbsent(season, k -> new HashMap<>());
//
//                // Populate seasonData with crop quantities for each season
//                HashMap<String, Integer> seasonCropQuantityMap = seasonData.get(season);
//                for (String crop : cropNames) {
//                    int quantity = cropQuantityMap.getOrDefault(crop, 0);
//                    seasonCropQuantityMap.put(crop, quantity);
//                }
//            }
//        }
//
//        // Print or use the seasonData as needed
////        System.out.println("Season Data: " + seasonData);
//
//    }
    
  public static void futureCropDataPredictionNew() {
    System.out.println("Crop call ");
    List<String> cropNames = new ArrayList<>(Arrays.asList(
            "Wheat", "Tomato", "Corn", "Lettuce", "Rice",
            "Potato", "Cucumber", "Strawberry", "Carrot", "Spinach",
            "Orange", "Broccoli", "Avocado", "Blueberries", "Pumpkin"));
    List<String> seasons = new ArrayList<>(Arrays.asList("Winter", "Summer", "Spring", "Autumn", "Monsoon"));

    // Assign the current marketData and seasonData to futureMarketData and futureSeasonData
    futureMarketData = marketData;
    futureSeasonData = new HashMap<>();

    for (int year = 2023; year <= 2025; year++) {
        // Add predicted data for the current year to futureMarketData
        ArrayList<CropSalesRelation> cropSalesList = new ArrayList<>();

        for (String crop : cropNames) {
            int historicalQuantity = futureMarketData.get(year - 1)
                    .stream()
                    .filter(csr -> csr.getCrop().getName().equals(crop))
                    .findFirst()
                    .map(csr -> csr.getSales().getQuantity())
                    .orElse(0);

            int growthPercentage = calculateGrowthPercentage(crop, historicalQuantity);
            int predictedQuantity = (int) (historicalQuantity * (1 + growthPercentage / 100.0));

            Crop cropObject = new Crop();
            cropObject.setName(crop);
            cropObject.setType(getRandomType());
            cropObject.setSeason(getRandomSeason(seasons));
            cropObject.setCharacteristics(new ArrayList<>());

            Sales sales = new Sales();
            sales.setQuantity(predictedQuantity);

            CropSalesRelation cropSalesRelation = new CropSalesRelation(cropObject, sales);
            cropSalesList.add(cropSalesRelation);
        }

        futureMarketData.put(year, cropSalesList);

        // Populate futureSeasonData based on the predicted futureMarketData
        for (String season : seasons) {
            ArrayList<CropSalesRelation> seasonCropSalesList = new ArrayList<>();

            for (CropSalesRelation csr : cropSalesList) {
                if (csr.getCrop().getSeason().equals(season)) {
                    seasonCropSalesList.add(new CropSalesRelation(csr.getCrop(), csr.getSales()));
                }
            }

            // Remove duplicates based on crop names within each season
            Set<Crop> uniqueCrops = new HashSet<>();
            seasonCropSalesList.removeIf(csr -> !uniqueCrops.add(csr.getCrop()));

            futureSeasonData.computeIfAbsent(season, k -> new ArrayList<>());
            futureSeasonData.get(season).addAll(seasonCropSalesList);
        }
        
        
        
    }

    for (String season : seasons) {
    // Create a set to keep track of unique crop names within the season
    Set<String> uniqueCropNames = new HashSet<>();

    // Get the list of CropSalesRelation for the current season
    ArrayList<CropSalesRelation> seasonCropSalesList = futureSeasonData.getOrDefault(season, new ArrayList<>());

    // Iterate through the list and remove duplicates based on crop names
    seasonCropSalesList.removeIf(cropSalesRelation -> {
        String cropName = cropSalesRelation.getCrop().getName();
        // If the crop name is already in the set, remove the duplicate
        if (uniqueCropNames.contains(cropName)) {
            return true;
        }
        // Otherwise, add the crop name to the set and keep the entry
        uniqueCropNames.add(cropName);
        return false;
    });

    // Update the futureSeasonData with the modified list
    futureSeasonData.put(season, seasonCropSalesList);
}
    for (int year = 2023; year <= 2025; year++) {
        System.out.println("Year: " + year);
        System.out.println("Market Data: " + futureMarketData.get(year));
        for (String season : seasons) {
            System.out.println("Season Data for " + season + ": " + futureSeasonData.get(season).size());
        }
        System.out.println();
    }
}


private static boolean containsCrop(List<CropSalesRelation> list, Crop crop) {
    return list.stream().anyMatch(csr -> csr.getCrop().equals(crop));
}




//   public static void futureCropDataPrediction() {
//    List<String> cropNames = new ArrayList<>(Arrays.asList(
//            "Wheat", "Tomato", "Corn", "Lettuce", "Rice",
//            "Potato", "Cucumber", "Strawberry", "Carrot", "Spinach",
//            "Orange", "Broccoli", "Avocado", "Blueberries", "Pumpkin"));
//
//    List<String> seasons = new ArrayList<>(Arrays.asList("Winter", "Summer", "Spring", "Autumn", "Monsoon"));
//
//    futureMarketData = new HashMap<>();
//    futureSeasonData = new HashMap<>();
//
//    for (int year = 2023; year <= 2025; year++) {
//        ArrayList<CropSalesRelation> cropSalesList = new ArrayList<>();
//
//        // Calculate percentage growth for each crop based on historical data
//        for (String crop : cropNames) {
//            int historicalQuantity = futureMarketData.get(year - 1)
//                    .stream()
//                    .filter(csr -> csr.getCrop().getName().equals(crop))
//                    .findFirst()
//                    .map(csr -> csr.getSales().getQuantity())
//                    .orElse(0);
//
//            int growthPercentage = calculateGrowthPercentageNew(crop, historicalQuantity);
//            int predictedQuantity = (int) (historicalQuantity * (1 + growthPercentage / 100.0));
//
//            Crop cropObject = new Crop();
//            cropObject.setName(crop);
//            cropObject.setType(getRandomType()); // Assuming you have a method to get a random type
//            cropObject.setSeason(getRandomSeason(seasons));
//            cropObject.setCharacteristics(new ArrayList<>()); // Set characteristics as needed
//
//            Sales sales = new Sales();
//            sales.setQuantity(predictedQuantity);
//
//            CropSalesRelation cropSalesRelation = new CropSalesRelation(cropObject, sales);
//            cropSalesList.add(cropSalesRelation);
//        }
//
//        // Add predicted data for the current year to futureMarketData
//        futureMarketData.put(year, cropSalesList);
//
//        // Populate futureSeasonData based on the predicted futureMarketData
//        for (String season : seasons) {
//            HashMap<String, CropSalesRelation> seasonCropSalesMap = new HashMap<>();
//
//            for (CropSalesRelation csr : cropSalesList) {
//                seasonCropSalesMap.put(csr.getCrop().getName(), csr);
//            }
//
//            futureSeasonData.computeIfAbsent(season, k -> new HashMap<>());
//            futureSeasonData.get(season).putAll(seasonCropSalesMap);
//        }
//    }
//
//    for (int year = 2023; year <= 2025; year++) {
//        System.out.println("Year: " + year);
//        System.out.println("Market Data: " + futureMarketData.get(year));
//        System.out.println("Season Data: " + futureSeasonData);
//        System.out.println();
//    }
//}


    private static int calculateGrowthPercentage(String crop, int historicalQuantity) {
        // You can customize growth rates based on your domain knowledge or historical
        // trends
        Map<String, Integer> cropGrowthRates = new HashMap<>();
        cropGrowthRates.put("Wheat", 5);
        cropGrowthRates.put("Tomato", 8);
        cropGrowthRates.put("Corn", 6);
        cropGrowthRates.put("Lettuce", 4);
        cropGrowthRates.put("Rice", 7);
        cropGrowthRates.put("Potato", 5);
        cropGrowthRates.put("Cucumber", 6);
        cropGrowthRates.put("Strawberry", 9);
        cropGrowthRates.put("Carrot", 5);
        cropGrowthRates.put("Spinach", 4);
        cropGrowthRates.put("Orange", 6);
        cropGrowthRates.put("Broccoli", 7);
        cropGrowthRates.put("Avocado", 8);
        cropGrowthRates.put("Blueberries", 9);
        cropGrowthRates.put("Pumpkin", 5);

        return cropGrowthRates.getOrDefault(crop, 2); // Default growth rate is 2% if not specified
    }

    // Helper method to generate a random subset of crops
    private static List<String> getRandomSubset(List<String> cropNames) {
        Random random = new Random();
        int subsetSize = random.nextInt(cropNames.size()) + 1; // Random subset size (1 to cropNames.size())
        List<String> selectedCrops = new ArrayList<>(cropNames);
        while (selectedCrops.size() > subsetSize) {
            selectedCrops.remove(random.nextInt(selectedCrops.size()));
        }
        return selectedCrops;
    }

    // Helper method to generate random quantities (adjust range as needed)
    private static int getRandomQuantity() {
        Random random = new Random();
        return random.nextInt(91) + random.nextInt(120,400); // Assuming quantities range from 60 to 150
    }

    private static ArrayList<CropSalesRelation> parseDocumentToCropSalesRelationList(Document document) {
        ArrayList<CropSalesRelation> resultList = new ArrayList<>();

        if (document != null) {
            ArrayList<Document> cropSalesList = document.get("Market_based", ArrayList.class);

            for (Document cropSalesDocument : cropSalesList) {
                Document cropDocument = cropSalesDocument.get("crop", Document.class);
                Document salesDocument = cropSalesDocument.get("sales", Document.class);

                Crop crop = new Crop();
                crop.setName(cropDocument.getString("name"));
                crop.setType(cropDocument.getString("type"));
                crop.setSeason(cropDocument.getString("season"));
                crop.setCharacteristics(cropDocument.get("characteristics", ArrayList.class));

                Sales sales = new Sales();
                sales.setQuantity(salesDocument.getInteger("quantity"));

                CropSalesRelation relation = new CropSalesRelation(crop, sales);
                resultList.add(relation);
            }
        }

        return resultList;
    }

    private static HashMap<String, CropSalesRelation> parseDocumentToSeasonBasedDataMap(Document document) {
        
         HashMap<String, CropSalesRelation> resultMap = new HashMap<>();
         System.out.println("Keys "+document.keySet());
        if (document != null) {
            Document seasonBasedDataDocument = document.get("Season_based", Document.class);

            for (String season : seasonBasedDataDocument.keySet()) {
                Document cropSalesDocument = seasonBasedDataDocument.get(season, Document.class);

                Document cropDocument = cropSalesDocument.get("crop", Document.class);
                Document salesDocument = cropSalesDocument.get("sales", Document.class);

                Crop crop = new Crop();
                crop.setName(cropDocument.getString("name"));
                crop.setType(cropDocument.getString("type"));
                crop.setSeason(cropDocument.getString("season"));
                crop.setCharacteristics(cropDocument.get("characteristics", ArrayList.class));

                Sales sales = new Sales();
                sales.setQuantity(salesDocument.getInteger("quantity"));

                CropSalesRelation relation = new CropSalesRelation(crop, sales);
                resultMap.put(season, relation);
            }
        }

        return resultMap;
    }

    private static Document getDesiredDocument(FindIterable<Document> documents) {
        int count = 0;
        for (Document doc : documents) {
            if (count == 1) {
                return doc;
            }
            count++;
        }
        return null; 
    }
    
  public static void generatePreviousYearsMarketDataNew() {
    List<String> cropNames = new ArrayList<>(Arrays.asList(
            "Wheat", "Tomato", "Corn", "Lettuce", "Rice",
            "Potato", "Cucumber", "Strawberry", "Carrot", "Spinach",
            "Orange", "Broccoli", "Avocado", "Blueberries", "Pumpkin"));
    List<String> seasons = new ArrayList<>(Arrays.asList("Winter", "Summer", "Spring", "Autumn", "Monsoon"));

    // Populate marketData and seasonData
    populateData(cropNames, seasons);

    // Print the populated data for verification
    System.out.println("marketData: " + marketData);
    System.out.println("seasonData: " + seasonData);
}

private static void populateData(List<String> cropNames, List<String> seasons) {
    for (int year = 2018; year <= 2022; year++) {
        ArrayList<CropSalesRelation> cropSalesList = new ArrayList<>();
        for (String cropName : cropNames) {
            Crop crop = new Crop();
            crop.setName(cropName);
            crop.setType(getRandomType());
            crop.setSeason(getRandomSeason(seasons));
            crop.setCharacteristics(new ArrayList<>()); // Set characteristics as needed

            Sales sales = new Sales();
            sales.setQuantity(getRandomQuantityNew());

            CropSalesRelation cropSalesRelation = new CropSalesRelation(crop, sales);
            cropSalesList.add(cropSalesRelation);
        }
        marketData.put(year, cropSalesList);
    }

    for (String season : seasons) {
        ArrayList<CropSalesRelation> cropSalesList = new ArrayList<>();
        for (String cropName : cropNames) {
            Crop crop = new Crop();
            crop.setName(cropName);
            crop.setType(getRandomType());
            crop.setSeason(season);
            crop.setCharacteristics(new ArrayList<>()); // Set characteristics as needed

            Sales sales = new Sales();
            sales.setQuantity(getRandomQuantityNew());

            CropSalesRelation cropSalesRelation = new CropSalesRelation(crop, sales);
            cropSalesList.add(cropSalesRelation);
        }
        seasonData.put(season, cropSalesList);
    }
}


     
      private static String getRandomSeason(List<String> seasons) {
        int randomIndex = (int) (Math.random() * seasons.size());
        return seasons.get(randomIndex);
    }

    private static int getRandomQuantityNew() {
        return (int) (Math.random() * 100); // Change the range of quantity as needed
    }

    private static String getRandomType() {
        int randomIndex = (int) (Math.random() * types.size());
        return types.get(randomIndex);
    }
    

    private static int calculateGrowthPercentageNew(String crop, int historicalQuantity) {
        // Implement your logic for calculating growth percentage
        // This is a placeholder, you may replace it with your actual logic
        return (int) (Math.random() * 10);
    }

    private static int getHistoricalQuantity(String crop, int year) {
        // Implement your logic to retrieve historical quantity for a crop and year
        // This is a placeholder, you may replace it with your actual logic
        return (int) (Math.random() * 100);
    }

    private static String getRandomTypeNew() {
        // Implement your logic to get a random type from the predefined list
        // This is a placeholder, you may replace it with your actual logic
        List<String> types = Arrays.asList("Grain", "Vegetable", "Fruit");
        int randomIndex = (int) (Math.random() * types.size());
        return types.get(randomIndex);
    }

}