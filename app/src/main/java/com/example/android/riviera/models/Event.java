package com.example.android.riviera.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Index;

/**
 * Created by thealgo on 2/6/18.
 */

public class Event extends RealmObject {

    @SerializedName("_id")
    @Expose
    @Index
    public String id;
    @SerializedName("event_name")
    @Expose
    public String eventName;
    @SerializedName("event_description")
    @Expose
    public String eventDescription;
    @SerializedName("event_category")
    @Expose
    public String eventCategory;
    @SerializedName("event_subcategory")
    @Expose
    private String eventSubcategory;
    @SerializedName("event_mainCategory")
    @Expose
    private String eventMainCategory;
    @SerializedName("event_previous")
    @Expose
    public Boolean eventPrevious;
    @SerializedName("event_previous_details")
    @Expose
    public String eventPreviousDetails;
    @SerializedName("event_fest")
    @Expose
    public String eventFest;
    @SerializedName("event_rules")
    @Expose
    public String eventRules;
    @SerializedName("event_requirements")
    @Expose
    public String eventRequirements;
    @SerializedName("event_duration")
    @Expose
    public String eventDuration;
    @SerializedName("event_external_judge")
    @Expose
    public Boolean eventExternalJudge;
    @SerializedName("event_team")
    @Expose
    public String eventTeam;
    @SerializedName("event_no_participants")
    @Expose
    public String eventNoParticipants;
    @SerializedName("event_expected_internal")
    @Expose
    public String eventExpectedInternal;
    @SerializedName("event_expected_external")
    @Expose
    public String eventExpectedExternal;
    @SerializedName("event_sponsorship")
    @Expose
    public String eventSponsorship;
    @SerializedName("event_chapter")
    @Expose
    public String eventChapter;
    @SerializedName("event_prizes")
    @Expose
    public String eventPrizes;
    @SerializedName("event_budget")
    @Expose
    public String eventBudget;
    @SerializedName("event_theme")
    @Expose
    public String eventTheme;
    @SerializedName("event_reg_fees")
    @Expose
    public String eventRegFees;
    @SerializedName("event_chapter_name")
    @Expose
    public String eventChapterName;
    @SerializedName("event_preference")
    @Expose
    public String eventPreference;
    @SerializedName("event_coordinators")
    @Expose
    public String eventCoordinator;
    @SerializedName("event_overall")
    @Expose
    public String eventOverall;
    @SerializedName("timestamp")
    @Expose
    public String timestamp;
    @SerializedName("checked")
    @Expose
    public Boolean checked;
}