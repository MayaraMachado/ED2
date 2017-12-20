package ed2;

import java.nio.ByteBuffer;

public class Aluno implements Persistable{
	private String nome;
    private String curso;
    private int matricula;
    private float media;     
	private ByteBuffer buffer;

    public Aluno(){
    	
    }
    
    public Aluno(String nome, String curso, int matricula){
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public void calculaMedia(float nota1, float nota2, float nota3, float nota4){
        media = (nota1 + nota2 + nota3 + nota4)/ 4;
    }

    public int calculaEspacoTotal() {
        return 4 + curso.length() + nome.length() ;
    }

    public int calculaTamanho(String valor){
        return valor.length();
    }

	@Override
	public void persist() {
		   try{
	        	int alocar = calculaTamanho(nome) + calculaTamanho(curso)+12;
	            this.buffer = ByteBuffer.allocate(alocar);
	            this.buffer.put(nome.getBytes());
	            this.buffer.put(curso.getBytes());
	            this.buffer.putInt(matricula);
	            this.buffer.putFloat(media);
	    
	            this.buffer.flip();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
		
	}

	@Override
	public void recover() {
		// TODO Auto-generated method stub		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public float getMedia() {
		return media;
	}

	public void setMedia(float media) {
		this.media = media;
	}

	public ByteBuffer getBuffer() {
		return buffer;
	}

	public void setBuffer(ByteBuffer buffer) {
		this.buffer = buffer;
	}
	

}
