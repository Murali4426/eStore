package eStore;


import eStore.utils.SetupWebDriver;
import eStore.pages.ProductListPage;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationTestContext.xml"})
@Transactional
public class ProductListTest extends SetupWebDriver {

    @Test
    public void productListTest() {
        int rowCount = 5;
        ProductListPage page = new ProductListPage(driver);
        Assert.assertEquals(rowCount, page.getRowCount());
    }

    @Test
    public void searchProductTest() {
        int expected = 1;

        ProductListPage page = new ProductListPage(driver);
        Assert.assertEquals(expected, page.searchProduct("AirPods"));
    }
}
