import java.util.ArrayList;

public class Calculadora 
{
	public static double avaliar(Polinomio p, double x)
	{
		double res = 0;
		for(int i = 0; i <= p.grau(); i++)
		{
			res += p.coeficiente(i) * Math.pow(x, i);
		}
		return res;
	}
	
	public static Polinomio soma(Polinomio p1, Polinomio p2)
	{
		Polinomio maior, menor;
		ArrayList<Double> res = new ArrayList<Double>();
		if(p1.grau() >= p2.grau())
		{
			maior = p1;
			menor = p2;
		}
		else
		{
			maior = p2;
			menor = p1;
		}
		for(int i = 0; i <= maior.grau(); i++)
		{
			if(i <= menor.grau())
			{
				res.add(maior.coeficiente(i) + menor.coeficiente(i));
			}
			else
			{
				res.add(maior.coeficiente(i));
			}
		}
		Polinomio resp = new Polinomio(res);
		return resp;
	}
	
	public static Polinomio subtracao(Polinomio p1, Polinomio p2)
	{
		Polinomio maior, menor;
		ArrayList<Double> res = new ArrayList<Double>();
		ArrayList<Double> polList2 = new ArrayList<Double>();
		for(int i = 0; i <= p2.grau(); i++)
		{
			polList2.add(-(p2.coeficiente(i)));
		}
		Polinomio pol2 = new Polinomio(polList2);
		if(p1.grau() >= pol2.grau())
		{
			maior = p1;
			menor = pol2;
		}
		else
		{
			maior = pol2;
			menor = p1;
		}
		for(int i = 0; i <= maior.grau(); i++)
		{
			if(i <= menor.grau())
			{
				res.add(maior.coeficiente(i) + menor.coeficiente(i));
			}
			else
			{
				res.add(maior.coeficiente(i));
			}
		}
		Polinomio resp = new Polinomio(res);
		return resp;
	}
	
	public static Polinomio multiplicacao(Polinomio p1, Polinomio p2)
	{
		int novoTamanho = p1.grau() + p2.grau();
		ArrayList<Double> res = new ArrayList<Double>();
		for(int i = 0; i < novoTamanho; i++)
		{
			res.add(0.0);
		}
		for(int i = 0; i <= p1.grau(); i++)
		{
			for(int j = 0; j <= p2.grau(); j++)
			{
				if(p1.coeficiente(i) != 0 && p2.coeficiente(j) != 0)
				{
					res.add(i+j, res.get(i+j)+(p1.coeficiente(i)*p2.coeficiente(j)));
				}
			}
		}
		Polinomio resp = new Polinomio(res);
		return resp;
	}
	
	public static Polinomio derivada(Polinomio p)
	{
		ArrayList<Double> res = new ArrayList<Double>();
		for(int i = 1; i <= p.grau(); i++)
		{
			res.add(p.coeficiente(i) * i);
		}
		Polinomio resp = new Polinomio(res);
		return resp;
	}
	
	public static Double raiz_newton(Polinomio p, double x0, double error, int N)
	{
		int k = 0;
		return 0.0;
	}
}
