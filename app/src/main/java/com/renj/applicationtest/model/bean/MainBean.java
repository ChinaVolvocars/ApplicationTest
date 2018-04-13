package com.renj.applicationtest.model.bean;

import java.util.List;

/**
 * ======================================================================
 * <p>
 * 作者：Renj
 * <p>
 * 创建时间：2018-03-15   10:43
 * <p>
 * 描述：
 * <p>
 * 修订历史：
 * <p>
 * ======================================================================
 */
public class MainBean {

    /**
     * message : 成功
     * code : 200
     * data : [{"address":"1幢1楼","value":[{"name":"zhangsan","age":82,"sex":"man","type":3},{"name":"lisi","age":80,"sex":"man","type":2},{"name":"wangwu","age":65,"sex":"woman","type":1}]},{"address":"1幢2楼","value":[{"name":"zhangsan","age":82,"sex":"man","type":3},{"name":"lisi","age":80,"sex":"man","type":2},{"name":"wangwu","age":65,"sex":"woman","type":1}]}]
     */

    public String message;
    public int code;
    public List<DataEntity> data;

    public static class DataEntity {
        /**
         * address : 1幢1楼
         * value : [{"name":"zhangsan","age":82,"sex":"man","type":3},{"name":"lisi","age":80,"sex":"man","type":2},{"name":"wangwu","age":65,"sex":"woman","type":1}]
         */

        public String address;
        public List<ValueEntity> value;

        public static class ValueEntity {
            /**
             * name : zhangsan
             * age : 82
             * sex : man
             * type : 3
             */

            public String name;
            public int age;
            public String sex;
            public int type;
        }
    }
}
