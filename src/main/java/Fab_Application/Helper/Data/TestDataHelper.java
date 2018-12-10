package Fab_Application.Helper.Data;

import Fab_Application.Helper.Common.BaseTestClass;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.lang.reflect.Method;

public class TestDataHelper extends BaseTestClass {

    public TestDataHelper() {
    }

    @DataProvider(
            name = "ExcelDataProvider"
    )
    public static Object[][] getDataFromDataProvider(Method method) {
        String packageName = method.getDeclaringClass().getPackage().getName();
//        System.out.println(packageName);

        if (packageName.contains("Fab_Application")) {
            packageName = packageName.split("Fab_Application.")[1];
        }

        packageName = packageName.replace(".", "/");

        String pathName = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"test_data"+File.separator+packageName+File.separator+method.getName()+".xlsx";

        System.out.println("Pathname for excel is -> "+pathName);
        Object[][] testDataObject = ExcelHelper.getDataFromExcel(pathName);
        return testDataObject;
    }
}
