package plus.ultra.heroes.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

import static plus.ultra.heroes.constants.HeroesConstant.ENDPOINT_DYNAMO;
import static plus.ultra.heroes.constants.HeroesConstant.REGION_DYNAMO;

public class HeroesData {
    public static void main(String[] args) throws Exception {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Heroes_Api_Table");

        Item hero1 = new Item()
                .withPrimaryKey("id", "2")
                .withString("name", "Yagi Toshinori")
                .withString("alias", "All Might")
                .withString("quirk", "One For All")
                .withString("occupation", "Teacher");

        Item hero2 = new Item()
                .withPrimaryKey("id", "3")
                .withString("name", "Midoriya Izuku")
                .withString("alias", "Deku")
                .withString("quirk", "One For All")
                .withString("occupation", "Student");

        Item hero3 = new Item()
                .withPrimaryKey("id", "4")
                .withString("name", "Sasaki Mirai")
                .withString("alias", "Night Eye")
                .withString("quirk", "Foresight")
                .withString("occupation", "Pro Hero");

        PutItemOutcome outcome1 = table.putItem(hero1);
        PutItemOutcome outcome2 = table.putItem(hero2);
        PutItemOutcome outcome3 = table.putItem(hero3);

    }

}