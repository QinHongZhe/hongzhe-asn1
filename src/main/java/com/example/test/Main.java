package com.example.test;


import cn.hutool.core.util.HexUtil;
import com.alibaba.fastjson.JSON;
import com.gientech.tianjin2020.*;


import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {

        // 創建messageframe

		MessageFrame messageFrame = null;

		MapData mapMsg = new MapData();

		Vector nodes = new Vector();
		Node node = new Node();
		NodeReferenceID nodeReferenceID1 = new NodeReferenceID();
		nodeReferenceID1.region = 22;
		nodeReferenceID1.id = 232;


//		node.inLinks = inLinks;
		node.id = nodeReferenceID1;
		node.name = "232";
		Position3D position3D = new Position3D();
		position3D.long_= 1170368020;
		position3D.elevation = -20;
		position3D.lat = 390791446;
		node.refPos = position3D;
		nodes.add(node);
		//----------mapMsg
		mapMsg.msgCnt = 0;
		mapMsg.nodes = nodes;
		messageFrame = MessageFrame.mapFrame(mapMsg);

		System.out.println(JSON.toJSONString(messageFrame));

		 ByteArrayOutputStream bo = new ByteArrayOutputStream();
         // 2. 输出流
         OutputStream os = new OutputStream() {
             @Override
             public void write(final int b) {
                 bo.write(b);
             }
         };

         messageFrame.per_encode(true,os);
         System.out.println(HexUtil.encodeHex(bo.toByteArray(),true));



         //--- 解密
         String decodeStr = "1000184c99b2800b00746677f50b58861c0987f60d833266c16b266ca002c01cc051e605bd12f0102df8007800b0074c060005b800b00d3c05000540a3cc43ac430a30a677ecb560fed7588614f5ccefda99c1fdaeb10c2b1599dfb79183fb5d6218587d33bf73df07f6bac430b59e677ef1360fed758861748ccefdf55c1fdaeb10c2fbb99dfc10783fb5d621861c933bf86cb07f6bac430c83a677f170e0fed758861a30ccefe53fc1fdabc080b7c000e002c01d30280016028f310eb10c2a0699dfb15783fb5d6218565f33bf676b07f6bac430b162677ed84e0fed7588616c14cefdc38c1fdaeb10c2eab99dfbacf83fb5d62185fab33bf7a5b07f6bac430c3fa677efe260fed7588619144cefe0f3c1fdaeb10c335299dfc44583fb5d62186b4b33bf91ff07f6af0302df4007800b0074c0e0005b800b00d44048005c0a3cc43ac430ad22677ebf6e0fed758861638ccefd91cc1fdaeb10c2d9b99dfb49783fb5d62185d8933bf6deb07f6bac430bfb6677ee5460fed75886188bccefddd7c1fdaeb10c324099dfbe0d83fb5d621866d533bf80d707f6bac430d252677f0b1e0fed758861b73ccefe3c0c1fdac1993366b593365001600e9028f302e18978081704001c005806a2028003a051e621d621894d533bff7cb07f6bac43123b2677fe36e0fed7588623b6cceffae8c1fdaeb10c45ef99dff2c783fb5d621888f133bfdf9307f6bac4310c02677fb32e0fed7588620c4cceff4e7c1fdaeb10c401199dfe6d183fb5d62187d3333bfc7ab07f6bac430eea6677f776e0fed5e0405c20007001600e7814000f0147988758862494cceffeb0c1fdaeb10c47ab99dffa5783fb5d62188c5933bfee9b07f6bac43112ba677fd10e0fed75886219b4ceff8a2c1fdaeb10c41bf99dfee4983fb5d6218809133bfd69707f6bac430fb42677fa1360fed758861eac4ceff2a8c1fdaeb10c3a6899dfdf5783fb57818170a003c0058039e070003dc0058069e024003e051e621d62188fcf33bffdbf07f6bac43119a6677fef560fed7588622754ceffc65c1fdaeb10c436c99dff5c183fb5d621883e933bfe58707f6bac43101f6677fbf160fed758861f82cceff664c1fdaeb10c3d8d99dfe9cd83fb5d6218782b33bfcd9f07f6bac430e496677f835e0fed60cd19335ac99b2800b00d381456c08d80bc0411b7002e002c01cf032001be002c01d30140019e002c0351018001a028ad90eb10c1f1d99dfef7d83fb5d6218415f33bfdb2f07f6bac430890a677faece0fed7588611eacceff4e7c1fdaeb10c256899dfe7ed83fb5d62184df933bfcc1707f6bac430a23e677f90a60fed758861511cceff122c1fdaeb10c2bb699dfe06383fb5d62185db733bfb93707f6b0668c9a2d64cd94005806a00a2b6049405e02092b8017001600e780a0008f001600e98190009f001601a780c000901456c8758862b5accefd909c1fdaeb10c55cc99dfb32b83fb5d6218a78533bf6b3f07f6bac43146de677ee04e0fed7588627d6ccefdd43c1fdaeb10c4da399dfbcfb83fb5d6218973333bf7ee307f6bac431263e677f07960fed7588623c2ccefe22dc1fdaeb10c416999dfcbbb83fb40";

         byte[] messageFrame1 = HexUtil.decodeHex(decodeStr);

         ByteArrayInputStream inputStream = new ByteArrayInputStream(messageFrame1);

         DataInputStream dataInputStream = new DataInputStream(inputStream);

         MessageFrame messageFrame2 = MessageFrame.per_decode(false,dataInputStream);
         System.out.println(messageFrame2);
         System.out.println("333"+JSON.toJSONString(messageFrame2));

    }
}
