package com.swpuiot.schoolnews.emtity;

import java.util.List;

/**
 * Created by 羊荣毅_L on 2016/12/6.
 */
public class MasResponseEmpty {


    /**
     * content : [{"id":4,"title":"\u201c追梦路上\u201d校园新歌首唱会！","content":"4月22日，我校将开启\u201c小小的梦想\u201d微公益之\u201c追梦路上\u201d首唱会！","pubTime":1481464387000,"endTime":1483451581000,"departmentId":null,"facultyId":null,"typeId":null,"flag":true,"imageUrl":"http://www.bug666.cn:8080/Images/massage/4.jpg"},{"id":3,"title":"校文化部娱乐活动开启啦！","content":"校文化部娱乐活动开启啦！","pubTime":1481464350000,"endTime":1483365137000,"departmentId":null,"facultyId":null,"typeId":null,"flag":true,"imageUrl":"http://www.bug666.cn:8080/Images/massage/3.jpg"},{"id":2,"title":"为期15天的大一新生军训结束！","content":"大一新生迎来今天的军训结束日！欢呼吧！！！","pubTime":1481372375000,"endTime":1483276217000,"departmentId":null,"facultyId":null,"typeId":null,"flag":true,"imageUrl":"http://www.bug666.cn:8080/Images/massage/2.jpg"},{"id":1,"title":"校学生会招贤纳士啦！！！！！","content":"欢迎广大学生参加校学生会招纳活动！","pubTime":1481375437000,"endTime":1481461859000,"departmentId":null,"facultyId":null,"typeId":null,"flag":false,"imageUrl":"http://www.bug666.cn:8080/Images/massage/1.jpg"}]
     * totalPages : 1
     * totalElements : 4
     * last : true
     * first : true
     * sort : [{"direction":"DESC","property":"id","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}]
     * numberOfElements : 4
     * size : 15
     * number : 0
     */

    private int totalPages;
    private int totalElements;
    private boolean last;
    private boolean first;
    private int numberOfElements;
    private int size;
    private int number;
    /**
     * id : 4
     * title : “追梦路上”校园新歌首唱会！
     * content : 4月22日，我校将开启“小小的梦想”微公益之“追梦路上”首唱会！
     * pubTime : 1481464387000
     * endTime : 1483451581000
     * departmentId : null
     * facultyId : null
     * typeId : null
     * flag : true
     * imageUrl : http://www.bug666.cn:8080/Images/massage/4.jpg
     */

    private List<ContentBean> content;
    /**
     * direction : DESC
     * property : id
     * ignoreCase : false
     * nullHandling : NATIVE
     * ascending : false
     */

    private List<SortBean> sort;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public List<SortBean> getSort() {
        return sort;
    }

    public void setSort(List<SortBean> sort) {
        this.sort = sort;
    }

    public static class ContentBean {
        private int id;
        private String title;
        private String content;
        private long pubTime;
        private long endTime;
        private Object departmentId;
        private Object facultyId;
        private Object typeId;
        private boolean flag;
        private String imageUrl;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getPubTime() {
            return pubTime;
        }

        public void setPubTime(long pubTime) {
            this.pubTime = pubTime;
        }

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }

        public Object getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(Object departmentId) {
            this.departmentId = departmentId;
        }

        public Object getFacultyId() {
            return facultyId;
        }

        public void setFacultyId(Object facultyId) {
            this.facultyId = facultyId;
        }

        public Object getTypeId() {
            return typeId;
        }

        public void setTypeId(Object typeId) {
            this.typeId = typeId;
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }

    public static class SortBean {
        private String direction;
        private String property;
        private boolean ignoreCase;
        private String nullHandling;
        private boolean ascending;

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }

        public boolean isIgnoreCase() {
            return ignoreCase;
        }

        public void setIgnoreCase(boolean ignoreCase) {
            this.ignoreCase = ignoreCase;
        }

        public String getNullHandling() {
            return nullHandling;
        }

        public void setNullHandling(String nullHandling) {
            this.nullHandling = nullHandling;
        }

        public boolean isAscending() {
            return ascending;
        }

        public void setAscending(boolean ascending) {
            this.ascending = ascending;
        }
    }
}
