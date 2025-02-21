package joonseo.chap06.book.model;


public class Application {
    public static void main(String[] args) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.printInformation();

        BookDTO bookDTO1 = new BookDTO("자바의 정석","도우 출판","남궁성");
        bookDTO1.printInformation();

        BookDTO bookDTO2 = new BookDTO("홍길동전","활빈당","허균",500000,0.5);
        bookDTO2.printInformation();

    }
}
