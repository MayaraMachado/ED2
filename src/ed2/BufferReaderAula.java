package ed2;

public class BufferReaderAula {

	public static void main(String[] args) {

		Aluno aluno = new Aluno("Frederico", "Sistemas de Informacao", 465);
		aluno.calculaMedia((float) 6.7, (float) 8.9, (float) 5.4, (float) 7.3);

		BufferClass buffer = new BufferClass();
		buffer.escreverBuffer(aluno);
		
		aluno.persist();

		Aluno alunoLido = buffer.lerBuffer(aluno.getNome().length(), aluno.getCurso().length());

		System.out.print("Aluno\nNome: " + alunoLido.getNome()
							+ "\nCurso: " + alunoLido.getCurso() 
							+ "\nMatricula: "+ alunoLido.getMatricula() 
							+ "\nMédia: " + alunoLido.getMedia());

	
		Canal canal = new Canal();
		canal.escreverFile(20, aluno);
		
		//http://javarevisited.blogspot.com.br/2016/01/reading-writing-files-using-filechannel-bytebuffer-example.html
	}

}
