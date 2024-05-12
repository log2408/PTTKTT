package DSSinhVien_HashMap;

import java.util.Objects;

public class SinhVien implements Comparable<SinhVien> {
    private String hoTen;
    private Date ngaySinh;
    public SinhVien(String hoTen, Date ngaySinh) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
    }
    public String getHoTen() {
        return hoTen;
    }
    public Date getNgaySinh() {
        return ngaySinh;
    }
    @Override
    public int compareTo(SinhVien other) {
    	String[] thisParts = this.hoTen.split(" ");
        String[] otherParts = other.hoTen.split(" ");
        int compareHo = thisParts[thisParts.length - 1].compareTo(otherParts[otherParts.length - 1]);
        if (compareHo != 0) {
            return compareHo;
        }
        if (thisParts.length > 2 && otherParts.length > 2) {
            int compareDem = thisParts[thisParts.length - 2].compareTo(otherParts[otherParts.length - 2]);
            if (compareDem != 0) {
                return compareDem;
            }
        }
        return this.ngaySinh.compareTo(other.getNgaySinh());
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SinhVien sinhVien = (SinhVien) obj;
        return Objects.equals(hoTen, sinhVien.hoTen) && Objects.equals(ngaySinh, sinhVien.ngaySinh);
    }
    @Override
    public int hashCode() {
        return Objects.hash(hoTen, ngaySinh);
    }
}
