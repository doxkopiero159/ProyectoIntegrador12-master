package com.pierogranda.proyectointegrador12.model;

public class Career {
    private int id;
    private String code;
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString()
    {return "Career " +
            "[id=" + id +
            ", code=" + code +
            ", name=" + name +
            "]";
    }
}
