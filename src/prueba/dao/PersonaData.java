package prueba.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import archivos.Escritor;
import archivos.Lector;
import prueba.vo.PersonaVO;


public class PersonaData {
	
public PersonaData(){

	}
	public void escribirEmpleado(PersonaVO miPersona){
		try{
			File f=new File("Data/archivoEmpleado.txt");
			if(f.exists()){
				FileWriter fw=new FileWriter(f);
				BufferedWriter bw=new BufferedWriter(fw);
				bw.newLine();
				bw.write(miPersona.getIdPersona()+","+
				miPersona.getNombrePersona()+","+
				miPersona.getEdadPersona()+","+
				miPersona.getProfesionPersona()+","+
				miPersona.getTelefonoPersona());
			}
			}
			catch (Exception e){
				System.out.println(e);
			}
		}
	
	public void mostrarEmpleados(){
		try{
			File f=new File("Data/archivoEmpleado.txt");
			if(f.exists()){
				FileReader fr=new FileReader(f);
				BufferedReader br=new BufferedReader(fr);
				String linea;
				while((linea=br.readLine())!=null){
					String[] separador = linea.split(",");
					PersonaVO per=new PersonaVO(separador[0],
							separador[1],
							separador[2],
							separador[3],
							separador[4]);
					System.out.println("***********************************");
				}
			}
			else{
				System.out.println("Archivo no existente");
			}
		}
		catch (Exception e){
			System.out.println(e);
		}
	}	
}