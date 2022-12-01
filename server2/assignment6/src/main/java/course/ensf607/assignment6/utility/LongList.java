package course.ensf607.assignment6.utility;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class LongList {

    private List<Long> data;

    public LongList(List<Long> data) {
        this.data = data;
    }

    public void addLong(Long l) {
        data.add(l);
    }


    
}
