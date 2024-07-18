package org.can.pojo;


public class PostRequestData {
    private String name;
    private Data data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RequestData{" +
                "name='" + name + '\'' +
                ", data=" + data +
                '}';
    }

    public static class Data{
        private int year;
        private double price;
        private String CPUModel;
        private String hardDiskSize;

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getCPUModel() {
            return CPUModel;
        }

        public void setCPUModel(String CPUModel) {
            this.CPUModel = CPUModel;
        }

        public String getHardDiskSize() {
            return hardDiskSize;
        }

        public void setHardDiskSize(String hardDiskSize) {
            this.hardDiskSize = hardDiskSize;
        }


        @Override
        public String toString() {
            return "Data{" +
                    "year=" + year +
                    ", price=" + price +
                    ", CPUModel='" + CPUModel + '\'' +
                    ", hardDiskSize='" + hardDiskSize + '\'' +
                    '}';
        }
    }
}

