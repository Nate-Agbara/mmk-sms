package com.mmk.sms.dbhealth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author: Nathan
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DatabaseHealthTest {

    @Autowired
    DataSource dataSource;

    @Test
    void isDatabaseConnectionFine_returnsDBMetadata(){

            try {
                DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
                String catalogName = dataSource.getConnection().getCatalog();

                assertNotNull(metaData.nullPlusNonNullIsNull());
                assertEquals("mmk", catalogName);

            }catch (SQLException e){
                e.printStackTrace();
            }
        }
}
