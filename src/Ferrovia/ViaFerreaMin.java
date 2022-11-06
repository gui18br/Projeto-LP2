package Ferrovia;

import java.util.Stack;

public class ViaFerreaMin implements Vias{
	Stack<Object> viaFerreaMin = new Stack<>();
	ViaFerreaGra viaFerreaGra = new ViaFerreaGra();
	
	@Override
	public void embarque(Object dado) {
		viaFerreaMin.push(dado);
	}
	
	@Override
	public Object desembarcar() {
		return viaFerreaMin.pop();
	}

	@Override
	public void tranferir(Object via) {
		viaFerreaGra.embarque(desembarcar());
		
	}
}
