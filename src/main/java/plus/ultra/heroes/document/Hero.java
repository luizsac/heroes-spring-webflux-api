package plus.ultra.heroes.document;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data // gera getters e setters
@NoArgsConstructor
@DynamoDBTable(tableName="Heroes_Api_Table")
public class Hero {

    @Id
    @DynamoDBHashKey(attributeName = "id")
    private String id;

    @DynamoDBAttribute(attributeName = "name")
    private String name;

    @DynamoDBAttribute(attributeName = "alias")
    private String alias;

    @DynamoDBAttribute(attributeName = "quirk")
    private String quirk;

    @DynamoDBAttribute(attributeName = "occupation")
    private String occupation;

    public Hero(String id, String name, String alias, String quirk, String occupation) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.quirk = quirk;
        this.occupation = occupation;
    }

    public String getId() {
        return id;
    }
}
