package com.fuzeto.springbootdynamodb.repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.fuzeto.springbootdynamodb.SpringbootDynamodbApplication;
import com.fuzeto.springbootdynamodb.model.Product;
import com.fuzeto.springbootdynamodb.repositories.ProductRepository;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootDynamodbApplication.class)
@WebAppConfiguration
@TestPropertySource(properties = {
        "amazon.dynamodb.endpoint=http://localhost:8000",
        "amazon.aws.accesskey=key",
        "amazon.aws.secretkey=secret"
})
public class ProductRepositoryIntegrationTest {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    ProductRepository repository;

    private static final String EXPECTED_COST = "2000";

    @Before
    public void setup() throws Exception {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

        CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Product.class);
        tableRequest.setProvisionedThroughput(
                new ProvisionedThroughput(1L, 1L)
        );

        List<String> tables = amazonDynamoDB.listTables().getTableNames();

        if (tables.isEmpty()) {
            amazonDynamoDB.createTable(tableRequest);
        }

        dynamoDBMapper.batchDelete((List<Product>)repository.findAll());
    }

    @Test
    public void givenItemWithExpectedCost_whenRunFindAll_thenItemsIsFound() {

        Product product = Product.builder()
                .name("Macbook Pro")
                .cost("2000")
                .build();

        repository.save(product);
        List<Product> result = (List<Product>)repository.findAll();

        assertThat(result.size(), Is.is(greaterThan(0)));
        assertThat(result.get(0).getCost(), IsEqual.equalTo(EXPECTED_COST));
    }
}
