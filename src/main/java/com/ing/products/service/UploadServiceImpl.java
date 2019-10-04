package com.ing.products.service;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ing.products.entity.Category;
import com.ing.products.entity.Product;
import com.ing.products.exception.FailUploadException;
import com.ing.products.repository.CategoryRepository;
import com.ing.products.repository.ProductRepository;

@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ProductRepository productRepository;

	@Override
	public String upload(MultipartFile file) {

		try {
			Workbook workbook = new XSSFWorkbook(file.getInputStream());
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();

			String prevCatCell = "";
			Category catObj = null;
			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				String currCatCell = currentRow.getCell(1).getStringCellValue().trim();
				String prodCell = currentRow.getCell(2).getStringCellValue();
				String prodDescCell = currentRow.getCell(3).getStringCellValue();

				if (!currCatCell.equalsIgnoreCase("categoryName")) {
					if (!prevCatCell.equalsIgnoreCase(currCatCell)) {
						Category cat = new Category();
						cat.setCategoryName(currCatCell);
						catObj = categoryRepository.save(cat);
					}
					Product p = new Product();
					p.setProductName(prodCell);
					p.setDescription(prodDescCell);
					p.setCategory(catObj);
					productRepository.save(p);
					prevCatCell = currCatCell;
				}
			}

		} catch (Exception e) {
			throw new FailUploadException(e + "Failed to upload");
		}
		
		return "Successfully uploading file product-info.xlsx";
	}

}
