/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessObjects;

import businessObjects.ITrainer;
import businessObjects.Trainer;
import exceptions.NoNextTrainerFoundException;
import exceptions.NoPreviousTrainerFoundException;
import exceptions.NoTrainerFoundException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author Hendrik
 */
public class TrainerDaoXml implements ITrainerDao {
    @Override
    public ITrainer create() {
        ITrainer trainer = new Trainer();
        return trainer;
    }
    @Override
    public void delete(ITrainer trainer) {
        
    }
    @Override
    public ITrainer first() throws NoTrainerFoundException {
        try {
            File xmlFile = new File("databases/trainer.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
        
            NodeList nList = doc.getElementsByTagName("trainer");
            Node nNode = nList.item(0);
        
            if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                
                if(Integer.parseInt(eElement.getAttribute("id")) < 1) {
                    throw new NoTrainerFoundException("Database is empty.");
                }
                
                Trainer trainer = new Trainer();
                trainer.setId(Integer.parseInt(eElement.getAttribute("id")));
                trainer.setName(eElement.getElementsByTagName("Name").item(0).getTextContent());
                trainer.setAlter(Integer.parseInt(eElement.getElementsByTagName("Alter").item(0).getTextContent()));
                trainer.setErfahrung(Integer.parseInt(eElement.getElementsByTagName("Erfahrung").item(0).getTextContent()));
                return trainer;
            }
        }
        catch(NullPointerException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public ITrainer last() throws NoTrainerFoundException {
        try {
            File xmlFile = new File("databases/trainer.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
        
            NodeList nList = doc.getElementsByTagName("trainer");
            Node nNode = nList.item(0);
            nNode = nNode.getParentNode().getLastChild();
            
            if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                
                if(Integer.parseInt(eElement.getAttribute("id")) < 1) {
                    throw new NoTrainerFoundException("Database is empty.");
                }
                
                Trainer trainer = new Trainer();
                trainer.setId(Integer.parseInt(eElement.getAttribute("id")));
                trainer.setName(eElement.getElementsByTagName("Name").item(0).getTextContent());
                trainer.setAlter(Integer.parseInt(eElement.getElementsByTagName("Alter").item(0).getTextContent()));
                trainer.setErfahrung(Integer.parseInt(eElement.getElementsByTagName("Erfahrung").item(0).getTextContent()));
                return trainer;
            }
        }
        catch(NullPointerException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public ITrainer next(ITrainer trainer) throws NoNextTrainerFoundException {
        
    }
    @Override
    public ITrainer previous(ITrainer trainer) throws NoPreviousTrainerFoundException {
        
    }
    @Override
    public void save (ITrainer trainer) {
        
    }
    @Override
    public List<ITrainer> select() throws NoTrainerFoundException {
        
    }
    @Override
    public ITrainer select(int id) throws NoTrainerFoundException {
        
    }
}
