import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {

//    Đọc file
    public List<Integer> readFile(String filePath) {
        // thêm mảng numbers
        List<Integer> numbers = new ArrayList<>();
        // kiểm tra xem file có tồn tại
        try{
            File file = new File(filePath);

            if (!file.exists()){
                throw new FileNotFoundException();
            }
            // tạo bộ nhớ đệm để đọc trên nó
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null ){
                // ép kiểu số cho line rồi add vào numbers
                numbers.add(Integer.parseInt(line));
            }
            br.close();

        } catch (Exception e) {
            System.out.println("File khong ton tai hoac noi dung co loi!");
        }
        return numbers;
    }

    //Phương thức tìm max
    public  static  int findMax (List<Integer>  numbers ){
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)){
                max = numbers.get(i);
            }
        }
        return max;
    }

    // phương thức ghi giá trị lớn nhất vào file
    public void writeFile(String filePath,int max){
        try {
            FileWriter writer = new FileWriter(filePath,true);

            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Gia tri lon nhat la : " + max);
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("file-numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("result.txt",maxValue);
    }
}
