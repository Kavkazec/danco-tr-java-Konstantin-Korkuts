package com.danco.training.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.training.annotation.ProcessAnnotation;
import com.danco.training.comparator.GuestDateComparator;
import com.danco.training.comparator.GuestNameComparator;
import com.danco.training.comparator.GuestServicesCoastComparator;
import com.danco.training.comparator.GuestServicesDateCopmarator;
import com.danco.training.controller.api.IGuestService;
import com.danco.training.entity.GuestModel;
import com.danco.training.entity.ServiceModel;
import com.danco.training.properties.PropertiesReader;
import com.danco.training.properties.init.annotation.InitGuestAnnotation;
import com.danco.training.reader.ImportAndExport;
import com.danco.training.storage.Hotel;


// TODO: Auto-generated Javadoc
/**
 * The Class GuestService.
 */

public class GuestService implements IGuestService{
	
	private static final Logger LOGGER = Logger.getLogger(GuestService.class);
	
	/** The t. */
	private int t = 0;
	
	/** The hotel. */
	private Hotel hotel =  Hotel.getInstance();

	/**
	 * Instantiates a new guest service.
	 */
	
	/**
	 * Sort by name.
	 *
	 * @return the guests
	 */
	public List<GuestModel> printGuest(){
		try{
			return hotel.getGuest().getGuests();
		}  catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}
	
	/**
	 * Adds the guest.
	 *
	 * @param guest the guest
	 */
	public void addGuest(GuestModel guest) {
		try{
			hotel.addGuest(guest);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	/**
	 * Delete guest.
	 *
	 * @param guest the guest
	 */
	public void deleteGuest(String str){
		try{
			hotel.deleteGuest(str);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	/**
	 * Adds the service to guest.
	 *
	 * @param guest the guest
	 * @param service the service
	 */
	public void addServiceToGuest(String guest, String service){
		try{
			hotel.addServiceToGuest(guest, service);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	
	/**
	 * Sort by name.
	 *
	 * @return the list
	 */
	public List<GuestModel> sortByNameGuests(){
		try{
			Collections.sort(hotel.getGuest().getGuests(), new GuestNameComparator());
			return hotel.getGuest().getGuests();
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}
	
	/**
	 * Sort by date.
	 *
	 * @return the list
	 */
	public List<GuestModel> sortByDateGuests(){
		try{
			Collections.sort(hotel.getGuest().getGuests(), new GuestDateComparator());
			return hotel.getGuest().getGuests();
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}
	
	/**
	 * Show all guests.
	 *
	 * @return the int
	 */
	public int showNumberOfGuests(){
		try{
			for(int i = 0; i < hotel.getGuest().getGuests().size(); i++){
				t +=1;
			}		
			return t;
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return 0;
		}
	}
	
	/**
	 * Show list of services sorted by coast.
	 *
	 * @param guest the guest
	 * @return the list
	 */
	public List<ServiceModel> showGuestsServicesSortedByCoast(String name){
		try{
			List<ServiceModel> list = new ArrayList<ServiceModel>();
			for(GuestModel gm : hotel.getGuest().getGuests()){
				if(name.equals(gm.getName())){
					for(ServiceModel sm : gm.getServices()){
						list.add(sm);
					}
				}
			}
			Collections.sort(list, new GuestServicesCoastComparator());
			return list;
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}
	
	/**
	 * Show list of services sorted by date.
	 *
	 * @param guest the guest
	 * @return the list
	 */
	public List<ServiceModel> showGuestsServicesSortedByDate(String name){
		try{
			List<ServiceModel> list = new ArrayList<ServiceModel>();
			for(GuestModel gm : hotel.getGuest().getGuests()){
				if(name.equals(gm.getName())){
					for(ServiceModel sm : gm.getServices()){
						list.add(sm);
					}
				}
			}
			Collections.sort(list, new GuestServicesDateCopmarator());
			return list;
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}
	
	public void exportGuests(){
		try{
			PropertiesReader.getInstance().setProperties();
			ImportAndExport.getInstance().writeToFileGuests(PropertiesReader.getInstance().getUtil().getCsvPath());
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}	
	}
	
	public void importGuests(){
		try{
			PropertiesReader.getInstance().setProperties();
			hotel.getGuest().setGuests(ImportAndExport.getInstance().readFromFileGuests(PropertiesReader.getInstance().getUtil().getCsvPath()));
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	public List<ServiceModel> getService(String name){
		try{
			List<ServiceModel> list = new ArrayList<ServiceModel>();
			for(GuestModel gm : hotel.getGuest().getGuests()){
				if(name.equals(gm.getName())){
					for(ServiceModel sm : gm.getServices()){
						list.add(sm);
					}
				}
			}
			return list;
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}
	public void buildGuestsFromAnnot(){
		try{
			PropertiesReader.getInstance().setProperties();
			ProcessAnnotation p = new ProcessAnnotation();
			InitGuestAnnotation g = new InitGuestAnnotation();
			p.procAnnotation(g);
			hotel.getGuest().setGuests(g.guestList());
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
}
