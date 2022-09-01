package com.infopolus.dto;

import com.infopolus.entiry.Vehicle;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactDto {

  private int id;
  private String fullName;
  private List<Vehicle> vehicles;

}
