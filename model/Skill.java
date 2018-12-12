package com.pierogranda.proyectointegrador12.model;

public class Skill {
    private int id;
    private String skill;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
    @Override
    public String toString()
    {return "Skill " +
            "[id=" + id +
            ",skill=" + skill +


            "]";
    }


}
