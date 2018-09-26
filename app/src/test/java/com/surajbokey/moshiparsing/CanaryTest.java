package com.surajbokey.moshiparsing;

import com.squareup.moshi.Moshi;
import com.surajbokey.moshiparsing.support.Provider;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CanaryTest {

    private Moshi moshi = Provider.provideMoshi();


    @Test
    public void parsingTestWithNull() throws Exception {
        String json = "{\"name\":\"Suraj\", \"address\":null}";

        ParsingDemo parsingDemo = moshi.adapter(ParsingDemo.class).fromJson(json);
        System.out.println(parsingDemo);
    }


    @Test
    public void parsingTestWithoutKey() throws Exception {
        String json = "{\"name\":\"Suraj\"}";

        ParsingDemo parsingDemo = moshi.adapter(ParsingDemo.class).fromJson(json);
        System.out.println(parsingDemo);
    }


}