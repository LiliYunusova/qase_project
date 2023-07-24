package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cases {

    private String title;
    private String description;
    private String precondition;
    @SerializedName("suite_id")
    private int suiteId;
}
