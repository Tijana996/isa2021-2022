package com.ftn.ISA2122.dto;

public class SearchVikDTO {

    private String dateod;
    private String datedo;
    private String lokacija;
    private int ocena;

    public SearchVikDTO() {}

    public SearchVikDTO(String dateod, String datedo, String lokacija, int ocena) {
        this.dateod = dateod;
        this.datedo = datedo;
        this.lokacija = lokacija;
        this.ocena = ocena;
    }

    public SearchVikDTO(String s){
        String[] ss = s.split(":");
        for(String s1 : ss){
            System.out.println(s1);
        }
        this.dateod = ss[1].split(",")[0].replace("\"", "");
        this.datedo = ss[2].split(",")[0].replace("\"", "");
        this.lokacija = ss[3].split(",")[0].replace("\"", "");
        String num = ss[4].replace("\"", "").replace("}", "");
        this.ocena = Integer.parseInt(num);
    }

    public String getDateod() {
        return dateod;
    }

    public void setDateod(String dateod) {
        this.dateod = dateod;
    }

    public String getDatedo() {
        return datedo;
    }

    public void setDatedo(String datedo) {
        this.datedo = datedo;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }
}
