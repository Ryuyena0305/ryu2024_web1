package day06;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class ParkingDto {
	
	private int cno;
	private String carNum;
	private int carLo;
	private String inCar;
	private String outCar;
	private boolean state;
	

}
