package Ferrovia;

import java.util.Stack;

public class ViaFerreaGra implements Vias {
	Stack<Object> viaFerreaGra = new Stack<>();
	ViaFerreaMin viaFerreaMin = new ViaFerreaMin();
	
	@Override
	public void embarque(Object dado) {
		viaFerreaGra.push(dado);
	}
	
	@Override
	public Object desembarcar() {
		return viaFerreaGra.pop();
	}
	
	@Override
	public void tranferir(Object via) {
		viaFerreaMin.embarque(desembarcar());
	}
}
