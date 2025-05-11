/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.catlantis;

import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author DjRed
 */
public class TreeMenuBuilder {
    
    public String srcPath = "src/main/resources/";
               
            
        //Top TreeView Root - AnimalCare
    public TreeItem treeItemRootAnimalCare = new TreeItem("Állománykezelés");
         
            TreeItem treeItemAnimalCareReceipt = new TreeItem("Bekerülések",new ImageView(new Image(getClass().getResourceAsStream("cat_ico.jpg"))));
                TreeItem treeItemAnimalCareReceiptNew = new TreeItem("Új bekerülés");
                TreeItem treeItemAnimalCareReceiptEdit = new TreeItem("Bekerülés módosítása");
                TreeItem treeItemAnimalCareReceiptView = new TreeItem("Bekerülések böngészése");
           
            
            TreeItem treeItemAnimalCareDataBase = new TreeItem("Állomány nyilvántartás", new ImageView(new Image(getClass().getResourceAsStream("cate_ico.jpg"))));
                TreeItem treeItemAnimalCareDataBaseEdit = new TreeItem("Nyilvántartás módosítása");
                TreeItem treeItemAnimalCareDataBaseView = new TreeItem("Nyilvántartás megtekintése");
            
                        
            TreeItem treeItemAnimalCareCaring = new TreeItem("Kezelések", new ImageView(new Image(getClass().getResourceAsStream("cata_ico.jpg"))));
                TreeItem treeItemAnimalCareCaringNew = new TreeItem("Új kezelés");
                TreeItem treeItemAnimalCareCaringEdit = new TreeItem("Kezelés módosítása");
                TreeItem treeItemAnimalCareCaringView = new TreeItem("Kezelések adatainak megtekintése");
            
                        
            TreeItem treeItemAnimalCareAdoptation = new TreeItem("Örökbeadások", new ImageView(new Image(getClass().getResourceAsStream("catb_ico.jpg"))));
                TreeItem treeItemAnimalCareAdoptationNew = new TreeItem("Új örökbeadás");
                TreeItem treeItemAnimalCareAdoptationEdit = new TreeItem("Örökbeadás adatainak módosítása");
                TreeItem treeItemAnimalCareAdoptationView = new TreeItem("Örökbeadás adatainak megtekintése");
            
                       
            TreeItem treeItemAnimalCarePostCare = new TreeItem("Utógondozás", new ImageView(new Image(getClass().getResourceAsStream("catc_ico.jpg"))));
                TreeItem treeItemAnimalCarePostCareEdit = new TreeItem("Utógondozott adatainak módosítása");
                TreeItem treeItemAnimalCarePostCareView = new TreeItem("Utógondozott adatainak megtekintése");
            
            
            TreeItem treeItemAnimalCareReturns = new TreeItem("Visszakerülések", new ImageView(new Image(getClass().getResourceAsStream("catd_ico.jpg")))); //Csak már örökbeadott kerülhet vissza, állomány adatbázisból kiválasztani!
                TreeItem treeItemAnimalCareReturnsNew = new TreeItem("Új visszakerülés");
                TreeItem treeItemAnimalCareReturnsEdit = new TreeItem("Visszakerülés adatainak módosítása");
                TreeItem treeItemAnimalCareReturnsView = new TreeItem("Visszakerülés adatainak megtekintése");
            
            
    
    
    public  TreeItem treeItemRootFinancial = new TreeItem("Könyvelések");
            TreeItem treeItemFinancial = new TreeItem("Számlaforgalom");
            TreeItem treeItemFinancialNewIncomingInvoice = new TreeItem("Új beérkező számla");
            TreeItem treeItemFinancialEditIncomingInvoice = new TreeItem("Beérkező számla szerkesztése");
            TreeItem treeItemFinancialViewIncomingInvoice = new TreeItem("Beérkező számla megtekintése");
            
         
   
    public  TreeItem treeItemRootDonations = new TreeItem("Adománykezelés");
            TreeItem treeItemDonations = new TreeItem("Adományozások");
            TreeItem treeItemDonationsNewIncomingDonation = new TreeItem("Új beérkező adomány");
            TreeItem treeItemDonationsNewOutgoingDonation = new TreeItem("Új kimenő adomány");
            TreeItem treeItemDonationsEditDonation = new TreeItem("Adomány szerkesztése");
            TreeItem treeItemDonationsViewDonations = new TreeItem("Adományok megtekintése");
           
            
    public  TreeItem treeItemRootOrganization = new TreeItem("Egyesület");
            TreeItem treeItemOrganizationChart = new TreeItem("Szervezeti felépítés");
            TreeItem treeItemOrganizationChartView = new TreeItem("Szervezeti felépítés megtekintése");
           
            
        TreeItem treeItemOrganizationRelations = new TreeItem("Kapcsolatok");
            TreeItem treeItemOrganizationRelationsVeterinary = new TreeItem("Állatorvosi rendelők");
            TreeItem treeItemOrganizationRelationsShops = new TreeItem("Üzletek");
            TreeItem treeItemOrganizationRelationsShelters = new TreeItem("Állatmenhelyek");
            TreeItem treeItemOrganizationRelationsRescuers = new TreeItem("Állatmentő szervezetek");
                
            
        
     
        
     public TreeMenuBuilder(){
         
        
        treeItemAnimalCareReceipt.getChildren().addAll(
                    treeItemAnimalCareReceiptNew,
                    treeItemAnimalCareReceiptEdit,
                    treeItemAnimalCareReceiptView
            ); 
         
        treeItemAnimalCareDataBase.getChildren().addAll(
                    treeItemAnimalCareDataBaseEdit,
                    treeItemAnimalCareDataBaseView
            );
         
        treeItemAnimalCareCaring.getChildren().addAll(
                    treeItemAnimalCareCaringNew,
                    treeItemAnimalCareCaringEdit,
                    treeItemAnimalCareCaringView
            );
        
        
        treeItemAnimalCareAdoptation.getChildren().addAll(
                    treeItemAnimalCareAdoptationNew,
                    treeItemAnimalCareAdoptationEdit,
                    treeItemAnimalCareAdoptationView
            ); 
         
        treeItemAnimalCarePostCare.getChildren().addAll(
                    treeItemAnimalCarePostCareEdit,
                    treeItemAnimalCarePostCareView
            ); 
         
        treeItemAnimalCareReturns.getChildren().addAll(
                    treeItemAnimalCareReturnsNew,
                    treeItemAnimalCareReturnsEdit,
                    treeItemAnimalCareReturnsView
            ); 
        treeItemRootAnimalCare.getChildren().addAll(
                treeItemAnimalCareReceipt,
                treeItemAnimalCareDataBase,
                treeItemAnimalCareCaring,
                treeItemAnimalCareAdoptation,
                treeItemAnimalCarePostCare,
                treeItemAnimalCareReturns
        );  
        treeItemRootAnimalCare.setExpanded(true); 
         
        treeItemFinancial.getChildren().addAll(
                treeItemFinancialNewIncomingInvoice,
                treeItemFinancialEditIncomingInvoice,
                treeItemFinancialViewIncomingInvoice); 
        treeItemRootFinancial.getChildren().addAll(treeItemFinancial);
         
         
         
        treeItemDonations.getChildren().addAll(
                treeItemDonationsNewIncomingDonation,
                treeItemDonationsNewOutgoingDonation,
                treeItemDonationsEditDonation,
                treeItemDonationsViewDonations); 
        treeItemRootDonations.getChildren().addAll(treeItemDonations);
               
        
         
        treeItemOrganizationChart.getChildren().addAll(
                treeItemOrganizationChartView);
        
        
        treeItemOrganizationRelations.getChildren().addAll(
                treeItemOrganizationRelationsVeterinary,
                treeItemOrganizationRelationsShops,
                treeItemOrganizationRelationsShelters,
                treeItemOrganizationRelationsRescuers);
                
        treeItemRootOrganization.getChildren().addAll(
                treeItemOrganizationChart,
                treeItemOrganizationRelations);
        
        
        
        
     }   
    
}
