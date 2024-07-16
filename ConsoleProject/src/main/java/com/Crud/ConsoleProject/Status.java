package com.Crud.ConsoleProject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Status {
    private Integer id;
    private String name;

    public static final Status SCHEDULED = new Status ( 1 , "Scheduled" );
    public static final Status ACTIVE = new Status ( 3 , "Active" );
    public static final Status COMPLETED = new Status ( 4 , "Completed" );
    public static final Status DISABLED = new Status ( 5 , "Disabled" );

    private Status ( Integer id , String name ) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString ( ) {
        return "Status{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}