package controller;

import javax.swing.JOptionPane;

import model.PilhaInt;

public class NPRController {
	
	
	public void insereValor(PilhaInt p, int valor) {
		p.push(valor);
		
	}
	
	public int npr(PilhaInt p, String op) throws Exception {
		
		//Verifica se há pelo menos dois valores na pilha
		if (p.size() < 2) {
			throw new Exception("Não há valores suficientes para realizar a operação!");
			
		}
		int result = 0;
		
		//Verifica qual a operação escolhida pelo usuário
		switch (op) {
		case "+":
			result = p.pop();
			result += p.pop();
			break;
		case "-":
			result = p.pop();
			result = p.pop() - result;
			break;
		case "*":
			result = p.pop();
			result *= p.pop();
			break;
		case "/":
			result = p.pop();
			result = p.pop() / result;
			break;
		default:
			JOptionPane.showMessageDialog(null, "Operacao Invalida!");
			System.exit(0);
			break;
		}
		p.push(result);
		return result;
	}
}
