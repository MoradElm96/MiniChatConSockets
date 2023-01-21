package minichatLocalhost;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;


public class Servidor extends Observable implements Runnable {

	private int puerto;
	public Servidor(int puerto) {
		this.puerto=puerto;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ServerSocket servidor = null;
		Socket socket= null;
		DataInputStream flujoEntrada;
		DataOutputStream flujoSalida;
		
		
		
		
		try {
			
			servidor = new ServerSocket(puerto);
			System.out.println("servidor iniciado");
			
			
			
			while(true) {
				
				//se queda a la espera
				socket = servidor.accept();
				System.out.println("Cliente conectado");
				flujoEntrada = new DataInputStream(socket.getInputStream());
				
				
				//se queda a la espera que el cliente mande algo
				String mensaje = flujoEntrada.readUTF();
				
				
				System.out.println(mensaje);
				
				this.setChanged();
				this.notifyObservers(mensaje);
				this.clearChanged();
				
				
				
				
				
				socket.close();
				System.out.println("Cliente desconectado");
				
					
			}
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
