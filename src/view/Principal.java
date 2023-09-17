package view;
/*
 *  Como funciona a Notação Polonesa Reversa
 *  
 *  • Enquanto for digitado número, ele será empilhado.
 *  • Quando for digitada uma operação (+,-,*,/), 2 valores devem ser desempilhados, 
 *  se faz a operação com eles e o resultado retorna à pilha
 */
import javax.swing.JOptionPane;

import controller.NPRController;
import model.PilhaInt;

public class Principal {
	private static int cont;
	private static int vet[] = new int[10];
	
	public static void main(String[] args) {
		PilhaInt p = new PilhaInt();
		NPRController calc = new NPRController();
		
		int menu = 0;
		do {
			menu = Integer.parseInt(JOptionPane.showInputDialog("Digite:\n1 - Para inserir um valor \n2 - Para inserir uma operacao \n"
					+ "3 - Para visualizar a pilha \nOutro numero qualquer para finalizar"));
			switch (menu) {
			case 1:
				int valor = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero: ")); 
				calc.insereValor(p, valor);	//valor é inserido na pilha
				vet[cont] = valor;	//Adiciona o valor em uma posição do vetor
				cont++;	//Incrementa o contador
				break;
				
			case 2:
				
				String op;
				boolean condition = false;
				do {
					op = JOptionPane.showInputDialog("Insira uma operacao ('+','-','*','/'): ");
					if (op.equals("+") ||op.equals("-") || op.equals("*") || op.equals("/")) {
						condition = true;
					} else {
						JOptionPane.showMessageDialog(null, "Operacao Invalida!");
					}
				} while (!condition);
				try {
					int result = calc.npr(p, op);
					JOptionPane.showMessageDialog(null, "Resultado da operacao: "+result);
					
					cont--;
					vet[cont] = 0;	//Posição do vetor recebe 0
					cont--;	//Decrementa novamente o contador	
					vet[cont] = result;	//Posição no vetor recebe resultado da operação
					cont++;
					
				} catch (Exception e) {
					e.getMessage();
					System.err.println(e);
				}
				break;
			//Visualizar itens da pilha
			case 3:
				int tamanhoPilha = p.size();
				System.out.println("Valores armazenados: ");
				//Lista os valores da pilha 
				for (int i = 0; i < tamanhoPilha; i++) {
					System.out.println(vet[i]);
				}
				System.out.println("***************************************************************************");
				break;
			default:
				System.exit(0);
				break;
			}
			
				
		} while (menu  != 9);
	}

}
