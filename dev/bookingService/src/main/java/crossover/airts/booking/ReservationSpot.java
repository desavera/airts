package crossover.airts.booking;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "reservation_spot")
public class ReservationSpot {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int spot_id;
	
	@Column(name = "spot_name", nullable = false)
	private String name;
	
	@Column(name = "spot_code", nullable = false)
	private String code;

	public ReservationSpot() {}
	
	public ReservationSpot(int id,String name,String code) {
		
		this.spot_id = id;
		this.name = name;
		this.code = code;
	}
	
	public int getId() {
		return spot_id;
	}
	public void setId(int id) {
		this.spot_id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + spot_id;
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof ReservationSpot))
            return false;
        ReservationSpot other = (ReservationSpot) obj;
        if (spot_id != other.spot_id)
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "ReservationSpot [id=" + spot_id + ", Name=" + name + ", Code="
                + code + "]";
    }
 	
	
}
