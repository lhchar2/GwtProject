//package com.jaosn.gwtproject.shared.utils;
//
//import com.jaosn.gwtproject.shared.dto.Address;
//
//public class AddressUtil {
//	
//	private AddressUtil() {
//		
//	}
//
//	public static String getSingleLineAddress(Address dto) {
//		if (dto == null) return "";
//		
//		String floor = dto.getFloorNum();
//		String flat = dto.getUnitNum();
//		String buildingName = dto.getBuildNum();
//		String lotNum = dto.getHlLotNum();
//		String streetNum = dto.getStreetNum();
//		String streetName = dto.getStreetName();
//		String streetCatgDesc = dto.getStreetCatgDesc();
//		String sectionDesc = dto.getSectionDesc();
//		String districtDesc = dto.getDistrictDesc();
//		String areaDesc = dto.getAreaDesc();
//		
//		StringBuffer sb = new StringBuffer();
//
//		if (flat != null && !"".equals(flat.trim()) && !"null".equalsIgnoreCase(flat)) {
//			sb.append("Flat ");
//			sb.append(flat);
//			sb.append(" ");
//		}
//		
//		if (floor != null && !"".equals(floor.trim()) && !"null".equalsIgnoreCase(floor)) {
//			sb.append(floor);
//			sb.append("/F ");
//		}
//		
//		if (buildingName != null && !"".equals(buildingName.trim()) && !"null".equalsIgnoreCase(buildingName)) {
//			sb.append(buildingName);
//			sb.append(" ");
//		}
//
//		if (lotNum != null && !"".equals(lotNum.trim()) && !"null".equalsIgnoreCase(lotNum)) {
//			sb.append(lotNum);
//			sb.append(" ");
//		} else if (streetNum != null
//				&& !"".equals(streetNum.trim())
//				&& !"null".equalsIgnoreCase(streetNum)) {
//			sb.append(streetNum);
//			sb.append(" ");
//		}
//
//		if (streetName != null && !"".equals(streetName.trim()) && !"null".equalsIgnoreCase(streetName)) {
//			sb.append(streetName);
//			sb.append(" ");
//			sb.append(streetCatgDesc);
//			sb.append(" ");
//		}
//
//		if (sectionDesc != null && !"".equals(sectionDesc.trim()) && !"null".equalsIgnoreCase(sectionDesc)) {
//			sb.append(sectionDesc);
//			sb.append(" ");
//		}
//
//		if (districtDesc != null && !"".equals(districtDesc.trim()) && !"null".equalsIgnoreCase(districtDesc)) {
//			sb.append(districtDesc);
//			sb.append(" ");
//		}
//
//		if (areaDesc != null && !"".equals(areaDesc.trim()) && !"null".equalsIgnoreCase(areaDesc)) {
//			sb.append(areaDesc);
//			sb.append(" ");
//		}
//
//		if ("".equals(sb.toString().trim())) {
//			sb.append("--");
//		}
//		
//		return sb.toString();
//	}
//	
//	public static String getMultiLinesAddress(Address obj, String systemId) {
//		// return getSingleLineAddress(dto);
//		return getDisplayAddr(obj, systemId);
//	}
//
//	private static String getDisplayAddr(Address obj, String systemId) {
//		if (obj == null || systemId == null) {
//			return null;
//		}
//		String freeAddr = null;
//		if (SvcConstants.SYSTEM_ID_IMS.equals(systemId)) {
//			freeAddr = getIMSDisplayAddr(obj);
//		} else if (SvcConstants.SYSTEM_ID_LTS.equals(systemId)) {
//			freeAddr = getLTSDisplayAddr(obj);
//		} else if (SvcConstants.SYSTEM_ID_MOB.equals(systemId)) {
//			freeAddr = getMOBDisplayAddr(obj);
//		}
//		return freeAddr;
//	}
//
//	private static String getIMSDisplayAddr(Address address) {
//		StringBuilder addrBuffer = new StringBuilder();
//
//		if (StringUtils.isNotBlank(address.getHlLotNum())) {
//			addrBuffer.append("LOT HSE NO ");
//			addrBuffer.append(address.getHlLotNum());
//			addrBuffer.append(SvcConstants.LINE_SEPARATOR);
//		}
//		if (StringUtils.isNotBlank(address.getUnitNum())) {
//			addrBuffer.append("FT ");
//			addrBuffer.append(address.getUnitNum());
//			addrBuffer.append(" ");
//		}
//		if (StringUtils.isNotBlank(address.getFloorNum())) {
//			addrBuffer.append(address.getFloorNum());
//			addrBuffer.append("/F");
//			addrBuffer.append(" ");
//		}
//		if (StringUtils.isNotBlank(address.getBuildNum())) {
//			addrBuffer.append(address.getBuildNum());
//			addrBuffer.append(SvcConstants.LINE_SEPARATOR);
//		}
//		if (StringUtils.isNotBlank(address.getStreetNum())) {
//			addrBuffer.append(address.getStreetNum());
//			addrBuffer.append(" ");
//		}
//		if (StringUtils.isNotBlank(address.getStreetName())) {
//			addrBuffer.append(address.getStreetName());
//			addrBuffer.append(" ");
//		}
//		if (StringUtils.isNotBlank(address.getStreetCatgDesc())) {
//			addrBuffer.append(address.getStreetCatgDesc());
//			addrBuffer.append(SvcConstants.LINE_SEPARATOR);
//		}
//		if (StringUtils.isNotBlank(address.getSectionDesc())) {
//			addrBuffer.append(address.getSectionDesc().trim());
//			addrBuffer.append(SvcConstants.LINE_SEPARATOR);
//		}
//		if (StringUtils.isNotBlank(address.getDistrictDesc())) {
//			addrBuffer.append(address.getDistrictDesc());
//			addrBuffer.append(" ");
//		}
//		if (StringUtils.isNotBlank(address.getAreaDesc())) {
//			addrBuffer.append(address.getAreaDesc());
//			addrBuffer.append(" ");
//		}
//		return addrBuffer.toString();
//	}
//
//	private static String getLTSDisplayAddr(Address address) {
//		StringBuffer addrBuffer = new StringBuffer();
//
//		// line 1
//		if (StringUtils.isNotBlank(address.getUnitNum())) {
//			addrBuffer.append("FT ");
//			addrBuffer.append(address.getUnitNum());
//		}
//		if (StringUtils.isNotBlank(address.getFloorNum())) {
//			if (StringUtils.isNotBlank(address.getUnitNum())) {
//				addrBuffer.append(" ");
//			}
//			addrBuffer.append(address.getFloorNum());
//			addrBuffer.append("/F");
//		}
//		if (StringUtils.isNotBlank(address.getBuildNum())) {
//			if (StringUtils.isNotBlank(address.getUnitNum()) || StringUtils.isNotBlank(address.getFloorNum())) {
//				addrBuffer.append(" ");
//			}
//			addrBuffer.append(address.getBuildNum());
//		}
//		if (StringUtils.isNotBlank(address.getUnitNum()) || StringUtils.isNotBlank(address.getFloorNum()) || StringUtils.isNotBlank(address.getBuildNum())) {
//			addrBuffer.append(SvcConstants.LINE_SEPARATOR);
//		}
//		// line 2
//		if (StringUtils.isNotBlank(address.getHlLotNum())) {
//			addrBuffer.append("LOT NO ");
//			addrBuffer.append(address.getHlLotNum());
//			addrBuffer.append(SvcConstants.LINE_SEPARATOR);
//		} else {
//			if (StringUtils.isNotBlank(address.getStreetNum())) {
//				addrBuffer.append(address.getStreetNum());
//			}
//			if (StringUtils.isNotBlank(address.getStreetName())) {
//				if (StringUtils.isNotBlank(address.getStreetNum())) {
//					addrBuffer.append(" ");
//				}
//				addrBuffer.append(address.getStreetName());
//				addrBuffer.append(" ");
//				addrBuffer.append(StringUtils.trimToBlank(address.getStreetCatgDesc()));
//			}
//			if (StringUtils.isNotBlank(address.getStreetNum()) || StringUtils.isNotBlank(address.getStreetName())) {
//				addrBuffer.append(SvcConstants.LINE_SEPARATOR);
//			}
//		}
//		// line 3
//		if (StringUtils.isNotBlank(address.getSectionDesc())) {
//			addrBuffer.append(address.getSectionDesc());
//			addrBuffer.append(SvcConstants.LINE_SEPARATOR);
//		}
//		// line 4
//		if (StringUtils.isNotBlank(address.getDistrictDesc())) {
//			addrBuffer.append(address.getDistrictDesc());
//		}
//		if (StringUtils.isNotBlank(address.getAreaDesc())) {
//			if (StringUtils.isNotBlank(address.getDistrictDesc())) {
//				addrBuffer.append(" ");
//			}
//			addrBuffer.append(address.getAreaDesc());
//		}
//
//		// [start] HW on 20071204
//		// Bug Fix - DM Campaign Problem (Invalid Chars Find in DRG BA)
//		// return addrBuffer.toString();
//		String tab = String.valueOf((char) 9);
//		return addrBuffer.toString().replaceAll(tab, "");
//		// [end] HW on 20071204
//	}
//
//	private static String getMOBDisplayAddr(Address address) {
//		StringBuffer addrBuffer = new StringBuffer();
//
//		// line 1
//		if (StringUtils.isNotBlank(address.getUnitNum())) {
//			addrBuffer.append("FT ");
//			addrBuffer.append(address.getUnitNum());
//		}
//		if (StringUtils.isNotBlank(address.getFloorNum())) {
//			if (StringUtils.isNotBlank(address.getUnitNum())) {
//				addrBuffer.append(" ");
//			}
//			addrBuffer.append(address.getFloorNum());
//			addrBuffer.append("/F");
//		}
//		if (StringUtils.isNotBlank(address.getBuildNum())) {
//			if (StringUtils.isNotBlank(address.getUnitNum()) || StringUtils.isNotBlank(address.getFloorNum())) {
//				addrBuffer.append(" ");
//			}
//			addrBuffer.append(address.getBuildNum());
//		}
//		if (StringUtils.isNotBlank(address.getUnitNum()) || StringUtils.isNotBlank(address.getFloorNum()) || StringUtils.isNotBlank(address.getBuildNum())) {
//			addrBuffer.append(SvcConstants.LINE_SEPARATOR);
//		}
//		// line 2
//		if (StringUtils.isNotBlank(address.getHlLotNum())) {
//			addrBuffer.append("LOT NO ");
//			addrBuffer.append(address.getHlLotNum());
//			addrBuffer.append(SvcConstants.LINE_SEPARATOR);
//		} else {
//			if (StringUtils.isNotBlank(address.getStreetNum())) {
//				addrBuffer.append(address.getStreetNum());
//			}
//			if (StringUtils.isNotBlank(address.getStreetName())) {
//				if (StringUtils.isNotBlank(address.getStreetNum())) {
//					addrBuffer.append(" ");
//				}
//				addrBuffer.append(address.getStreetName());
//				addrBuffer.append(" ");
//				addrBuffer.append(StringUtils.trimToBlank(address.getStreetCatgDesc()));
//			}
//			if (StringUtils.isNotBlank(address.getStreetNum()) || StringUtils.isNotBlank(address.getStreetName())) {
//				addrBuffer.append(SvcConstants.LINE_SEPARATOR);
//			}
//		}
//		// line 3
//		if (StringUtils.isNotBlank(address.getSectionDesc())) {
//			addrBuffer.append(address.getSectionDesc());
//			addrBuffer.append(SvcConstants.LINE_SEPARATOR);
//		}
//		// line 4
//		if (StringUtils.isNotBlank(address.getDistrictDesc())) {
//			addrBuffer.append(address.getDistrictDesc());
//		}
//		if (StringUtils.isNotBlank(address.getAreaDesc())) {
//			if (StringUtils.isNotBlank(address.getDistrictDesc())) {
//				addrBuffer.append(" ");
//			}
//			addrBuffer.append(address.getAreaDesc());
//		}
//
//		return addrBuffer.toString();
//	}
//
//}
