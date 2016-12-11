package com.swpuiot.schoolnews.emtity;

import java.util.List;

/**
 * Created by 羊荣毅_L on 2016/12/6.
 */
public class MasResponseEmpty {


    /**
     * content : [{"id":2,"title":"测试2","content":"测试活动信息属于最新还是往期","pubTime":1481372375000,"endTime":1481289017000,"departmentId":null,"facultyId":null,"typeId":null,"flag":false},{"id":1,"title":"测试1","content":"测试活动信息属于最新还是往期","pubTime":1481375437000,"endTime":1481461859000,"departmentId":null,"facultyId":null,"typeId":null,"flag":true}]
     * totalElements : 2
     * totalPages : 1
     * last : true
     * first : true
     * sort : [{"direction":"DESC","property":"id","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}]
     * numberOfElements : 2
     * size : 15
     * number : 0
     */

    private int totalElements;
    private int totalPages;
    private boolean last;
    private boolean first;
    private int numberOfElements;
    private int size;
    private int number;
    /**
     * id : 2
     * title : 测试2
     * content : 测试活动信息属于最新还是往期
     * pubTime : 1481372375000
     * endTime : 1481289017000
     * departmentId : null
     * facultyId : null
     * typeId : null
     * flag : false
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

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
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
