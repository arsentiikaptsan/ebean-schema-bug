package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "test_table")
public class TestTable {

  private String testColumn;
}
