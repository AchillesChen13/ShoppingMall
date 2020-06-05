package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.print.attribute.standard.MediaSize.NA;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;
import com.sun.jndi.toolkit.url.Uri;

import dao.ICommodityDao;
import dao.impl.CommodityDao;
import entity.Commodity;
import model.CommodityCommand;
import model.CommodityCommandAdd;
import model.CommodityCommandModify;
import model.CommodityInvoker;
import service.ICommodityService;
import service.impl.CommodityService;

public class CommodityAction extends SuperAction implements ModelDriven<Commodity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Commodity comm = new Commodity();
	private ICommodityService commodityService = new CommodityService();
	private CommodityInvoker invoker = new CommodityInvoker();
	private CommodityCommand command;
	
	private String savePath = ServletActionContext.getRequest().getRealPath("/cImg");
	private File upload;
	private String uploadFileName;

	private String uploadContentType;

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	//命令模式：命令一(添加商品)
	// 添加商品
	public String addCommodity() throws Exception {
		System.out.println("执行addCommodity()……");
		ICommodityDao cdao = new CommodityDao();
		if ((comm.getCommodityName() != null) && (comm.getContent() != null) && (comm.getPrice() != 0)
				&& (comm.getProduceDate() != null) && (comm.getQualityDate() != 0)
				&& (comm.getStock() != 0) && (comm.getTypeName() != null) && (comm.getUnit() != null)) {

			String uri =null;
			uri = "../cImg/"+uploadImg();
			comm.setImgUri(uri);
			System.out.println("comm:"+comm);
			
			//执行商品添加命令
			command = new CommodityCommandAdd(commodityService);
			System.out.println(command);
			invoker.setCommand(command);
			invoker.startExcuteCommand(comm);
			
			return "add_commodity_success";
		} else {
			return "add_commodity_failure";
		}
	}

	// 查询所有商品
	public String queryAllCommodity() {

		System.out.println("执行queryAllCommodity()……");

		String qcFlag = request.getParameter("qcFlag");

		ICommodityDao cdao = new CommodityDao();
		List<Commodity> list = cdao.selectCommodityAll();
		if (list != null && list.size() > 0) {
			session.setAttribute("commodity_list", list);
		}
		if (qcFlag != "0") {
			if (qcFlag.equals("1")) {
				return "query_commodity_successs_list";
			} else {
				return "query_commodity_successs_manage";
			}
		}
		return "query_commodity_successs";
	}

	// 修改商品信息
	public String modifyCommodityById() {
		System.out.println("执行modifyCommodityById()……");
		ICommodityDao cdao = new CommodityDao();

		String id = request.getParameter("commodityNo");
		Commodity com = cdao.selectCommodityById(id);
		session.setAttribute("modify_commodity", com);

		return "modify_commodity_success";
	}

	// 查询单个商品
	public String queryCommodityById() {
		System.out.println("执行queryCommodityById()……");
		ICommodityDao cdao = new CommodityDao();
		String id = request.getParameter("commodityNo");
		Commodity com = cdao.selectCommodityById(id);

		session.setAttribute("query_commodity", com);

		return "query_commodity_success";
	}

	//命令模式：命令二(修改商品)
	// 修改商品的信息
	public String modifyCommodity() {
		System.out.println("执行modifyCommodity()……");
		ICommodityDao cdao = new CommodityDao();
		if ((comm.getCommodityName() != null) && (comm.getContent() != null) && (comm.getPrice() != 0)
				&& (comm.getImgUri() != null) && (comm.getProduceDate() != null) && (comm.getQualityDate() != 0)
				&& (comm.getStock() != 0) && (comm.getTypeName() != null) && (comm.getUnit() != null)) {
			
			Commodity commodity = commodityService.selectCommodityById(comm.getCommodityNo());
			comm.setImgUri(commodity.getImgUri());
			
			//执行商品修改命令
			command = new CommodityCommandModify(commodityService);
			invoker.setCommand(command);
			invoker.startExcuteCommand(comm);
			return "update_commodity_success";
		} else {
			return "update_commodity_failure";
		}
	}

	public String upload(String newName) throws Exception {
		String strNewFileName = UUID.randomUUID().toString();
		String suffix = uploadFileName.substring(uploadFileName.lastIndexOf("."));
		strNewFileName += suffix;
		System.out.println(strNewFileName);
		FileOutputStream fos = new FileOutputStream(savePath+"\\" + strNewFileName);
		uploadFileName = strNewFileName;
		FileInputStream fis = new FileInputStream(getUpload());
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0) {
			fos.write(buffer, 0, len);
		}
		fos.close();
		return newName;
	}
	
	// 图片
	public String uploadImg() {
		String newName = null;
		System.out.println(newName);
		try {
			String realPath = ServletActionContext.getRequest().getRealPath("/cImg");

			System.out.println(realPath);

			String suffix = uploadFileName.substring(uploadFileName.lastIndexOf("."));
			System.out.println(suffix);
			String cNo = commodityService.creatCommodityId();
			newName = cNo + suffix;
			System.out.println(suffix);
			System.out.println(newName);
			FileInputStream is = new FileInputStream(getUpload());
			File file = new File(realPath, newName);

			FileOutputStream os = new FileOutputStream(file);
			int len = -1;
			byte[] buf = new byte[1024];
			while ((len = is.read(buf)) != -1) {
				os.write(buf, 0, len);
			}
			os.flush();
			os.close();
			is.close();
			// FileUtils.copyFile(upload, file);
			return newName;
		} catch (Exception e) {
			e.printStackTrace();
			return newName;
		}
	}

	// 图片上传处理
	public String imgDeal() throws IOException {

		if (!ServletFileUpload.isMultipartContent(request)) {
			System.out.println("不支持文件上传！");
		}
		// 创建FileItem 工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 创建文件核心组件
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 解析请求
		String pPath = "../cImg/";// 服务器的相对路径
		String aimDir = "/cImg";
		System.out.println("sPath:" + pPath);
		String cNo = commodityService.creatCommodityId();

		// File file = session.getAttribute("uploadImg");

		try {
			List items = upload.parseRequest(ServletActionContext.getRequest());
			Iterator iterator = items.iterator();

			while (iterator.hasNext()) {
				FileItem item = (FileItem) iterator.next();
				if (!item.isFormField()) {

					String name = item.getName();
					// System.out.println("url+name:"+name);
					InputStream is = item.getInputStream();
					String[] strArray = name.split("\\\\");
					name = strArray[strArray.length - 1];
					System.out.println("name:" + name);

					// String dir = ServletActionContext.getRequest().getRealPath(aimDir);
					// System.out.println(dir);

					String path = request.getSession().getServletContext().getRealPath("") + "cImg";// 存入语句
					System.out.println("path路径" + path);

					String uPath = request.getRequestURI();
					System.out.println("uPath路径" + uPath);

					// 实例图片对象
					// pic.setPicture(pPath + name);
					System.out.println("数据库相对路径" + pPath + cNo);

					// 写入服务器
					File desc = new File(path, cNo + ".jpg");
					System.out.println("desc:" + desc);
					OutputStream os = new FileOutputStream(desc);
					int len = -1;
					byte[] buf = new byte[1024];
					while ((len = is.read(buf)) != -1) {
						os.write(buf, 0, len);
					}
					os.flush();
					os.close();
					is.close();
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pPath + cNo + ".jpg";
	}

	@Override
	public Commodity getModel() {
		// TODO Auto-generated method stub
		return this.comm;
	}

}
