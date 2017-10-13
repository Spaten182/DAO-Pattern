/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessObjects;

import businessObjects.*;
import exceptions.*;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

/**
 *
 * @author Niklas
 */
public class TrainerDaoXml implements ITrainerDao {
    @Override
    public ITrainer create()
    {
        Trainer trainer=new Trainer();
		
        return trainer;
    }
	
	
    @Override
    public void delete(ITrainer trainer)
    {
        try
        {
            File xmlFile = new File("databases/trainer.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            NodeList nList=doc.getElementsByTagName("Trainer");
		
            for(int temp=0;temp<nList.getLength();temp++)
            {
                Node node=nList.item(temp);
			
                Element e= (Element) node;

                if(trainer.getId()==Integer.parseInt(e.getAttribute("id")))
                {
                    node.getParentNode().removeChild(node);
                }
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);

        }
        catch(Exception e)
        {
        }
    }
	
    @Override
    public ITrainer first() throws NoTrainerFoundException
    {
        try
        {
            File xmlFile = new File("databases/trainer.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
		
            NodeList nList=doc.getElementsByTagName("Trainer");
		
            Node node=nList.item(0);
		
            if(node!=null)
            {
                Element e= (Element) node;
		
                Trainer trainer=new Trainer();
                trainer.setId(Integer.parseInt(e.getAttribute("id")));
                trainer.setName(e.getElementsByTagName("Name").item(0).getTextContent());
                trainer.setAlter(Integer.parseInt(e.getElementsByTagName("Alter").item(0).getTextContent()));
                trainer.setErfahrung(Integer.parseInt(e.getElementsByTagName("Erfahrung").item(0).getTextContent()));
                return trainer;
            }
            else
            {
                throw new NoTrainerFoundException("Database is empty.");
            }
        }
        catch(IOException | NumberFormatException | ParserConfigurationException | DOMException | SAXException e)
        {
        }
        return null;
    }
	
    @Override
    public ITrainer last() throws NoTrainerFoundException
    {
        try
        {
            File xmlFile = new File("databases/trainer.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);


            NodeList nList=doc.getElementsByTagName("Trainer");
		
            Node node=nList.item(0).getParentNode().getLastChild();
		
            if(node!=null)
            {
                Element e= (Element) node;
		
                Trainer trainer=new Trainer();
                trainer.setId(Integer.parseInt(e.getAttribute("id")));
                trainer.setName(e.getElementsByTagName("Name").item(0).getTextContent());
                trainer.setAlter(Integer.parseInt(e.getElementsByTagName("Alter").item(0).getTextContent()));
                trainer.setErfahrung(Integer.parseInt(e.getElementsByTagName("Erfahrung").item(0).getTextContent()));
                return trainer;
            }
            else
            {
                throw new NoTrainerFoundException("Database is empty.");
            }
        }
        catch(NoTrainerFoundException | IOException | NumberFormatException | ParserConfigurationException | DOMException | SAXException e)
        {
        }
        return null;
    }
	
    @Override
    public ITrainer next(ITrainer trainer) throws NoNextTrainerFoundException
    {
        try
        {
            File xmlFile = new File("databases/trainer.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);	
            
            NodeList nList=doc.getElementsByTagName("Trainer");
            
            for (int temp = 0; temp < nList.getLength(); temp++)
            {
                Node nNode = nList.item(temp);
				
                if (nNode.getNodeType() == Node.ELEMENT_NODE) 
                {
                    Element e = (Element) nNode;

                    String id=e.getAttribute("id");

                    if(trainer.getId()==Integer.parseInt(id))
                    {
                        if(nList.item(temp+1)!=null)
                        {
                            Trainer trainer2=new Trainer();	
							
                            nNode=nList.item(temp+1);
                            e=(Element)nNode;

                            trainer2.setId(Integer.parseInt(e.getAttribute("id")));
                            trainer2.setName(e.getElementsByTagName("Name").item(0).getTextContent());
                            trainer2.setAlter(Integer.parseInt(e.getElementsByTagName("Alter").item(0).getTextContent()));
                            trainer2.setErfahrung(Integer.parseInt(e.getElementsByTagName("Erfahrung").item(0).getTextContent()));
                            return trainer2;
                        }
                        else
                        {
                            throw new NoNextTrainerFoundException("No next Trainer found.");
                        }
                    }
                }
            }
        }
        catch(IOException | NumberFormatException | ParserConfigurationException | DOMException | SAXException e)
        {
        }
        return null;
    }
	
    @Override
    public ITrainer previous(ITrainer trainer) throws NoPreviousTrainerFoundException
    {
        try
        {
            File xmlFile = new File("databases/trainer.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            NodeList nList=doc.getElementsByTagName("Trainer");
            
            for (int temp = 0; temp < nList.getLength(); temp++)
            {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) 
                {
                    Element e = (Element) nNode;

                    String id=e.getAttribute("id");

                    if(trainer.getId()==Integer.parseInt(id))
                    {
                        if(nList.item(temp-1)!=null)
                        {	
                            Trainer trainer2=new Trainer();	
						
                            nNode=nList.item(temp-1);
                            e=(Element)nNode;

                            trainer2.setId(Integer.parseInt(e.getAttribute("id")));
                            trainer2.setName(e.getElementsByTagName("Name").item(0).getTextContent());
                            trainer2.setAlter(Integer.parseInt(e.getElementsByTagName("Alter").item(0).getTextContent()));
                            trainer2.setErfahrung(Integer.parseInt(e.getElementsByTagName("Erfahrung").item(0).getTextContent()));
                            return trainer2;
                        }
                        else
                        {
                            throw new NoPreviousTrainerFoundException("No previous Trainer found.");
                        }
                    }
                }
            }
        }
        catch(IOException | NumberFormatException | ParserConfigurationException | DOMException | SAXException e)
        {
        }
        return null;
    }
	
    @Override
    public void save(ITrainer trainer)
    {
        try
        {
            File xmlFile = new File("databases/trainer.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            StringBuilder sbid = new StringBuilder();
            sbid.append(trainer.getId());
            String id = sbid.toString();
            
            StringBuilder sbAlter = new StringBuilder();
            sbAlter.append(trainer.getAlter());
            String alter = sbAlter.toString();

            StringBuilder sbErfahrung = new StringBuilder();
            sbErfahrung.append(trainer.getErfahrung());
            String erfahrung = sbErfahrung.toString();

            Element dataTag = doc.getDocumentElement();
            Element trainerTag = (Element) dataTag.getElementsByTagName("Trainers").item(0);
			
            Element newTrainer = doc.createElement("Trainer");
            newTrainer.setAttribute("id", id);

            Element eName = doc.createElement("Name");
            eName.setTextContent(trainer.getName());

            Element eAlter = doc.createElement("Alter");
            eAlter.setTextContent(alter);

            Element eErfahrung = doc.createElement("Erfahrung");
            eErfahrung.setTextContent(erfahrung);

            trainerTag.appendChild(newTrainer);

            newTrainer.appendChild(eName);
            newTrainer.appendChild(eAlter);
            newTrainer.appendChild(eErfahrung);			

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);

        }
        catch(Exception e)
        {
        }	
    }
	
    @Override
    public List<ITrainer> select() throws NoTrainerFoundException
    {
        try
        {
            File xmlFile = new File("databases/trainer.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            List<ITrainer> trainerList= new ArrayList<ITrainer>();

            NodeList nList= doc.getElementsByTagName("Trainer");
            
            if(nList.item(0) == null)
            {
                throw new NoTrainerFoundException("Database is empty.");
            }
            
            for (int temp = 0; temp < nList.getLength(); temp++)
            {
                Node nNode = nList.item(temp);
                
                if (nNode.getNodeType() == Node.ELEMENT_NODE) 
                {
                    Element e = (Element) nNode;

                    Trainer trainer=new Trainer();
                    trainer.setId(Integer.parseInt(e.getAttribute("id")));
                    trainer.setName(e.getElementsByTagName("Name").item(0).getTextContent());
                    trainer.setAlter(Integer.parseInt(e.getElementsByTagName("Alter").item(0).getTextContent()));
                    trainer.setErfahrung(Integer.parseInt(e.getElementsByTagName("Erfahrung").item(0).getTextContent()));

                    trainerList.add(trainer);
                }
            }
            return trainerList;
        }
        catch(NoTrainerFoundException | IOException | NumberFormatException | ParserConfigurationException | DOMException | SAXException e)
        {
        }
        return null;
    }
	
    @Override
    public ITrainer select(int id) throws NoTrainerFoundException
    {
        try
        {
            File xmlFile = new File("databases/trainer.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            
            Trainer trainer=new Trainer();

            NodeList nList= doc.getElementsByTagName("Trainer");
            
            for (int temp = 0; temp < nList.getLength(); temp++)
            {
                Node nNode = nList.item(temp);
                
                if (nNode.getNodeType() == Node.ELEMENT_NODE) 
                {
                    Element e = (Element) nNode;
                    
                    if(id==Integer.parseInt(e.getAttribute("id")))
                    {
                        trainer.setId(Integer.parseInt(e.getAttribute("id")));
                        trainer.setName(e.getElementsByTagName("Name").item(0).getTextContent());
                        trainer.setAlter(Integer.parseInt(e.getElementsByTagName("Alter").item(0).getTextContent()));
                        trainer.setErfahrung(Integer.parseInt(e.getElementsByTagName("Erfahrung").item(0).getTextContent()));
                        return trainer;
                    }
                }
            }		
        }
        catch(IOException | NumberFormatException | ParserConfigurationException | DOMException | SAXException e)
        {
            return null;
        }
        throw new NoTrainerFoundException("No Trainer with that ID exists.");
    }
}
