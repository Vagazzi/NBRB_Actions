import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Currency {

    @JsonProperty("Cur_ID")
    private int currencyID;

    @JsonProperty("Cur_OfficialRate")
    private Double currencyOfficialRate;

    @JsonProperty("Date")
    private String currencyDate;

    @JsonProperty("Cur_Abbreviation")
    private String currencyAbbreviation;

    @JsonProperty("Cur_Scale")
    private Integer currencyScale;

    @JsonProperty("Cur_Name")
    private String currencyName;

}
