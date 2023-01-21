package minichatLocalhost;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente implements Runnable{

	private int puerto;
	private String HOST;
	private String mensaje;
	
	public Cliente(String host,int puerto, String mensaje) {
		this.HOST=host;
		this.puerto= puerto;
		this.mensaje = mensaje;
	}

	@Override
	public void run() {
	
		
		
		
		
			DataOutputStream flujoSalida;
			
			try {

				Socket socket = new Socket(HOST, puerto);
				
			
				flujoSalida = new DataOutputStream(socket.getOutputStream());
				
				flujoSalida.writeUTF(mensaje);
			
				socket.close();

			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
	}
}
