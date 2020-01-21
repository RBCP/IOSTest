package utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class JSONDataProvider {
    public static String dataFile="/Users/liucuilv/IdeaProjects/IOSTest/data/";
    public static String testCaseName="NA";
    public JSONDataProvider() throws Exception{


    }
    @DataProvider(name="fetchData_JSON")
    public static Object[][] fetchData(Method method) throws Exception{
        Object[][] result;
        testCaseName=method.getName();
        dataFile+="/"+testCaseName+".json";
        List<JSONObject> testDataList=new ArrayList<JSONObject>();
        JSONArray testData=(JSONArray)extractData(dataFile);
        for(int i=0;i<testData.size();i++){
            testDataList.add((JSONObject) testData.get(i));
        }
        result=new Object[testDataList.size()][testDataList.get(0).size()];
        for(int i=0;i<testDataList.size();i++){
            result[i]=new Object[]{testDataList.get(i)};
        }
        return result;

    }
    public static JSONArray extractData(String file) throws Exception{
        InputStream inputStream=new FileInputStream(file);
        String text= IOUtils.toString(inputStream,"utf-8");
        return (JSONArray)JSONArray.parseArray(text);

    }

}
