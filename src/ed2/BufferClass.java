package ed2;

import java.nio.ByteBuffer;

class BufferClass{

    private ByteBuffer buffer;
    private Aluno aluno;

    public BufferClass(){
        aluno = new Aluno();
    }

    public void escreverBuffer(Aluno aluno){
        try{
        	int alocar = aluno.calculaTamanho(aluno.getNome()) + aluno.calculaTamanho(aluno.getCurso())+12;
            this.buffer = ByteBuffer.allocate(alocar);
            this.buffer.put(aluno.getNome().getBytes());
            this.buffer.put(aluno.getCurso().getBytes());
            this.buffer.putInt(aluno.getMatricula());
            this.buffer.putFloat(aluno.getMedia());
    
            this.buffer.flip();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Aluno lerBuffer(int alunoNomeLenght, int alunoCursoLenght){

        try {
            byte[] alunoNomeBB = new byte[alunoNomeLenght];
            byte[] alunoCursoBB = new byte[alunoCursoLenght];
    
            buffer.get(alunoNomeBB);
            aluno.setNome(new String(alunoNomeBB));
    
            buffer.get(alunoCursoBB);
            aluno.setCurso(new String(alunoCursoBB));
    
            aluno.setMatricula(buffer.getInt());
    
            aluno.setMedia(buffer.getFloat());
            
            buffer.flip();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return aluno;

    }

    public void clearBuffer(){
        buffer.clear();
        aluno = new Aluno();
    }
}