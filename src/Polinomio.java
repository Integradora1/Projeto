import java.util.ArrayList;

public class Polinomio 
{
	ArrayList<Double> polinomio;
	
	public Polinomio(String p)
	{
		this.polinomio = new ArrayList<Double>();
		String[] split1 = p.split(" ");
		int index = 0;
		for(String s1: split1)
		{
			String[] split2 = s1.split("\\^");
			double coeficiente = Double.parseDouble(split2[0]);
			int expoente = Integer.parseInt(split2[1]);
			while(index < expoente) 
			{
				this.polinomio.add(0.0);
				index++;
			}
			this.polinomio.add(coeficiente);
			index++;
		}
	}
	
	public Polinomio(ArrayList<Double> p)
	{
		this.polinomio = p;
	}
	
	public Polinomio copia()
	{
		Polinomio p = new Polinomio((ArrayList<Double>)this.polinomio.clone());
		return p;
	}
	
	public int grau()
	{
		return (this.polinomio.size() - 1);
	}
	
	public double coeficiente(int i)
	{
		return this.polinomio.get(i);
	}
	
	public String formatString()
	{
		String res = "";
		for(int i = 0; i < this.polinomio.size(); i++)
		{
			if(this.polinomio.get(i) != 0)
			{
				res += this.polinomio.get(i) + "^" + i;
			}
		}
		return res;
	}
	
	@Override
	public String toString()
	{
		String res = "";
		for(int i = (this.polinomio.size() - 1); i >= 0; i--)
		{
			if(this.polinomio.get(i) != 0)
			{
				res += "(" + this.polinomio.get(i) + ")*" + "(x^" + i + ")";
			}
			if(i != 0)
			{
				res += "+";
			}
		}
		return res;
	}
	
	@Override
	public boolean equals(Object po)
	{
		if(po instanceof Polinomio)
		{
			Polinomio p = (Polinomio)po;
			if(this.grau() == p.grau())
			{
				for(int i = 0; i < this.polinomio.size(); i++)
				{
					if(this.coeficiente(i) != p.coeficiente(i))
					{
						return false;
					}					
				}				
				return true;
			}
			return false;
		}
		return false;		
	}	
}
