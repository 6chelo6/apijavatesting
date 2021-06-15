package entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Manages the Project class.
 */
public class Project extends ProjectBody{
    @SerializedName("Id")
    private int id;
    @SerializedName("ItemsCount")
    private byte itemsCount;
    @SerializedName("ItemType")
    private byte itemType;
    @SerializedName("ParentId")
    private String parentId;
    @SerializedName("Collapsed")
    private String collapsed;
    @SerializedName("ItemOrder")
    private byte itemOrder;
    @SerializedName("Children")
    private List<String> children;
    @SerializedName("IsProjectShared")
    private boolean isProjectShared;
    @SerializedName("ProjectShareOwnerName")
    private String projectShareOwnerName;
    @SerializedName("ProjectShareOwnerEmail")
    private String projectShareOwnerEmail;
    @SerializedName("IsShareApproved")
    private boolean isShareApproved;
    @SerializedName("IsOwnProject")
    private boolean isOwnProject;
    @SerializedName("LastSyncedDateTime")
    private String lastSyncedDateTime;
    @SerializedName("LastUpdatedDate")
    private String lastUpdatedDate;
    @SerializedName("Deleted")
    private boolean deleted;
    @SerializedName("SyncClientCreationId")
    private String syncClientCreationId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(byte itemsCount) {
        this.itemsCount = itemsCount;
    }

    public byte getItemType() {
        return itemType;
    }

    public void setItemType(byte itemType) {
        this.itemType = itemType;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCollapsed() {
        return collapsed;
    }

    public void setCollapsed(String collapsed) {
        this.collapsed = collapsed;
    }

    public byte getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(byte itemOrder) {
        this.itemOrder = itemOrder;
    }

    public List<String> getChildren() {
        return children;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }

    public boolean isProjectShared() {
        return isProjectShared;
    }

    public void setProjectShared(boolean projectShared) {
        isProjectShared = projectShared;
    }

    public String getProjectShareOwnerName() {
        return projectShareOwnerName;
    }

    public void setProjectShareOwnerName(String projectShareOwnerName) {
        this.projectShareOwnerName = projectShareOwnerName;
    }

    public String getProjectShareOwnerEmail() {
        return projectShareOwnerEmail;
    }

    public void setProjectShareOwnerEmail(String projectShareOwnerEmail) {
        this.projectShareOwnerEmail = projectShareOwnerEmail;
    }

    public boolean isShareApproved() {
        return isShareApproved;
    }

    public void setShareApproved(boolean shareApproved) {
        isShareApproved = shareApproved;
    }

    public boolean isOwnProject() {
        return isOwnProject;
    }

    public void setOwnProject(boolean ownProject) {
        isOwnProject = ownProject;
    }

    public String getLastSyncedDateTime() {
        return lastSyncedDateTime;
    }

    public void setLastSyncedDateTime(String lastSyncedDateTime) {
        this.lastSyncedDateTime = lastSyncedDateTime;
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getSyncClientCreationId() {
        return syncClientCreationId;
    }

    public void setSyncClientCreationId(String syncClientCreationId) {
        this.syncClientCreationId = syncClientCreationId;
    }
}
