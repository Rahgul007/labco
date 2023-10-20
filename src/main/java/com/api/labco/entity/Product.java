package com.api.labco.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name = "product_number")
    private String productNumber;
    @Column(name = "description")
    private String description;
    @Column(name = "cas_number")
    private String casNumber;
    @Column(name = "shipped_ICE")
    private String shippedICE;
    @Column(name = "unspsc_code")
    private String unspscCode;
    @Column(name = "bolling_point")
    private String bollingPoint;
    @Column(name = "storage_temperature")
    private String storageTemperature;
    @Column(name = "density")
    private String density;
    @Column(name = "drug_precursor")
    private String drugPrecursor;
    @Column(name = "einecs_no")
    private String einecsNo;
    @Column(name = "duel_use_meterial")
    private String  dualUseMaterial;
    @Column(name = "flash_point")
    private String flashPoint;
    @Column(name = "mdl_number")
    private String mdlNumber;
    @Column(name = "melting_Point")
    private String meltingPoint;
    @Column(name = "molecular_formula")
    private String molecularFormula;
    @Column(name = "molecular_weight")
    private String molecularWeight;
    @Column(name = "narcoticPermission")
    private String narcoticPermission;
    @Column(name = "net_weight")
    private String netWeight;
    @Column(name = "gross_weight")
    private String grossWeight;
    @Column(name = "unit_of_weight")
    private String unitOfWeight;
    @Column(name = "purity_grade")
    private String purityGrade;
    @Column(name = "r_phrases")
    private String rPhrases;
    @Column(name = "radio_active_material")
    private String radioactiveMaterial;
    @Column(name = "specific_activity")
    private String specificActivity;
    @Column(name = "synonyms")
    private String synonyms;
    @Column(name = "tariff_number")
    private String tariffNumber;
    @Column(name = "technical_name")
    private String technicalName;
    @Column(name = "volume")
    private String volume;
    @Column(name = "unit_of_volume")
    private String unitOfVolume;
    @Column(name = "createdAt")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updatedAt")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne(targetEntity = Application.class)
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    public Product(String productNumber, String description, String casNumber, String shippedICE, String unspscCode, String bollingPoint, String storageTemperature, String density, String drugPrecursor, String einecsNo, String dualUseMaterial, String flashPoint, String mdlNumber, String meltingPoint, String molecularFormula, String molecularWeight, String narcoticPermission, String netWeight, String grossWeight, String unitOfWeight, String purityGrade, String rPhrases, String radioactiveMaterial, String specificActivity, String synonyms, String tariffNumber, String technicalName, String volume, String unitOfVolume, LocalDateTime createdAt, LocalDateTime updatedAt, Application application) {
        this.productNumber = productNumber;
        this.description = description;
        this.casNumber = casNumber;
        this.shippedICE = shippedICE;
        this.unspscCode = unspscCode;
        this.bollingPoint = bollingPoint;
        this.storageTemperature = storageTemperature;
        this.density = density;
        this.drugPrecursor = drugPrecursor;
        this.einecsNo = einecsNo;
        this.dualUseMaterial = dualUseMaterial;
        this.flashPoint = flashPoint;
        this.mdlNumber = mdlNumber;
        this.meltingPoint = meltingPoint;
        this.molecularFormula = molecularFormula;
        this.molecularWeight = molecularWeight;
        this.narcoticPermission = narcoticPermission;
        this.netWeight = netWeight;
        this.grossWeight = grossWeight;
        this.unitOfWeight = unitOfWeight;
        this.purityGrade = purityGrade;
        this.rPhrases = rPhrases;
        this.radioactiveMaterial = radioactiveMaterial;
        this.specificActivity = specificActivity;
        this.synonyms = synonyms;
        this.tariffNumber = tariffNumber;
        this.technicalName = technicalName;
        this.volume = volume;
        this.unitOfVolume = unitOfVolume;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.application = application;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCasNumber() {
        return casNumber;
    }

    public void setCasNumber(String casNumber) {
        this.casNumber = casNumber;
    }

    public String getShippedICE() {
        return shippedICE;
    }

    public void setShippedICE(String shippedICE) {
        this.shippedICE = shippedICE;
    }

    public String getUnspscCode() {
        return unspscCode;
    }

    public void setUnspscCode(String unspscCode) {
        this.unspscCode = unspscCode;
    }

    public String getBollingPoint() {
        return bollingPoint;
    }

    public void setBollingPoint(String bollingPoint) {
        this.bollingPoint = bollingPoint;
    }

    public String getStorageTemperature() {
        return storageTemperature;
    }

    public void setStorageTemperature(String storageTemperature) {
        this.storageTemperature = storageTemperature;
    }

    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density;
    }

    public String getDrugPrecursor() {
        return drugPrecursor;
    }

    public void setDrugPrecursor(String drugPrecursor) {
        this.drugPrecursor = drugPrecursor;
    }

    public String getEinecsNo() {
        return einecsNo;
    }

    public void setEinecsNo(String einecsNo) {
        this.einecsNo = einecsNo;
    }

    public String getDualUseMaterial() {
        return dualUseMaterial;
    }

    public void setDualUseMaterial(String dualUseMaterial) {
        this.dualUseMaterial = dualUseMaterial;
    }

    public String getFlashPoint() {
        return flashPoint;
    }

    public void setFlashPoint(String flashPoint) {
        this.flashPoint = flashPoint;
    }

    public String getMdlNumber() {
        return mdlNumber;
    }

    public void setMdlNumber(String mdlNumber) {
        this.mdlNumber = mdlNumber;
    }

    public String getMeltingPoint() {
        return meltingPoint;
    }

    public void setMeltingPoint(String meltingPoint) {
        this.meltingPoint = meltingPoint;
    }

    public String getMolecularFormula() {
        return molecularFormula;
    }

    public void setMolecularFormula(String molecularFormula) {
        this.molecularFormula = molecularFormula;
    }

    public String getMolecularWeight() {
        return molecularWeight;
    }

    public void setMolecularWeight(String molecularWeight) {
        this.molecularWeight = molecularWeight;
    }

    public String getNarcoticPermission() {
        return narcoticPermission;
    }

    public void setNarcoticPermission(String narcoticPermission) {
        this.narcoticPermission = narcoticPermission;
    }

    public String getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(String netWeight) {
        this.netWeight = netWeight;
    }

    public String getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(String grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getUnitOfWeight() {
        return unitOfWeight;
    }

    public void setUnitOfWeight(String unitOfWeight) {
        this.unitOfWeight = unitOfWeight;
    }

    public String getPurityGrade() {
        return purityGrade;
    }

    public void setPurityGrade(String purityGrade) {
        this.purityGrade = purityGrade;
    }

    public String getrPhrases() {
        return rPhrases;
    }

    public void setrPhrases(String rPhrases) {
        this.rPhrases = rPhrases;
    }

    public String getRadioactiveMaterial() {
        return radioactiveMaterial;
    }

    public void setRadioactiveMaterial(String radioactiveMaterial) {
        this.radioactiveMaterial = radioactiveMaterial;
    }

    public String getSpecificActivity() {
        return specificActivity;
    }

    public void setSpecificActivity(String specificActivity) {
        this.specificActivity = specificActivity;
    }

    public String getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(String synonyms) {
        this.synonyms = synonyms;
    }

    public String getTariffNumber() {
        return tariffNumber;
    }

    public void setTariffNumber(String tariffNumber) {
        this.tariffNumber = tariffNumber;
    }

    public String getTechnicalName() {
        return technicalName;
    }

    public void setTechnicalName(String technicalName) {
        this.technicalName = technicalName;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getUnitOfVolume() {
        return unitOfVolume;
    }

    public void setUnitOfVolume(String unitOfVolume) {
        this.unitOfVolume = unitOfVolume;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productNumber='" + productNumber + '\'' +
                ", description='" + description + '\'' +
                ", casNumber='" + casNumber + '\'' +
                ", shippedICE='" + shippedICE + '\'' +
                ", unspscCode='" + unspscCode + '\'' +
                ", bollingPoint='" + bollingPoint + '\'' +
                ", storageTemperature='" + storageTemperature + '\'' +
                ", density='" + density + '\'' +
                ", drugPrecursor='" + drugPrecursor + '\'' +
                ", einecsNo='" + einecsNo + '\'' +
                ", dualUseMaterial='" + dualUseMaterial + '\'' +
                ", flashPoint='" + flashPoint + '\'' +
                ", mdlNumber='" + mdlNumber + '\'' +
                ", meltingPoint='" + meltingPoint + '\'' +
                ", molecularFormula='" + molecularFormula + '\'' +
                ", molecularWeight='" + molecularWeight + '\'' +
                ", narcoticPermission='" + narcoticPermission + '\'' +
                ", netWeight='" + netWeight + '\'' +
                ", grossWeight='" + grossWeight + '\'' +
                ", unitOfWeight='" + unitOfWeight + '\'' +
                ", purityGrade='" + purityGrade + '\'' +
                ", rPhrases='" + rPhrases + '\'' +
                ", radioactiveMaterial='" + radioactiveMaterial + '\'' +
                ", specificActivity='" + specificActivity + '\'' +
                ", synonyms='" + synonyms + '\'' +
                ", tariffNumber='" + tariffNumber + '\'' +
                ", technicalName='" + technicalName + '\'' +
                ", volume='" + volume + '\'' +
                ", unitOfVolume='" + unitOfVolume + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", application=" + application +
                '}';
    }
}
