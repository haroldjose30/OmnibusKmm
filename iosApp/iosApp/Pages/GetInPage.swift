//
//  GetInPage.swift
//  iosApp
//
//  Created by Harold Jose Barros Gonçalves on 02/05/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct GetInPage: View {
     @State private var number:String = ""
     @State private var name:String = ""
    var body: some View {
        VStack {
            
            Image(systemName: "figure.walk")
                .resizable()
                .aspectRatio(contentMode: .fill)
                .foregroundColor(.blue)
                .frame(width: 60, height: 60)
                .padding(.top,24)
            Spacer()
           
            VStack(alignment: .leading, spacing:8){
                
                Text("Numero da linha")
                TextField("Ex: 022", text: $number)
                    .textFieldStyle(RoundedBorderTextFieldStyle())
                    .padding(.bottom,40)
                Text("Nome da linha")
                TextField("Ex: Inter Bairros II", text: $name)
                    .textFieldStyle(RoundedBorderTextFieldStyle())
                    .padding(.bottom,40)

                Button(action: {
                     //TODO: get In action
                 }, label: {
                    HStack {
                        Spacer()
                        Text("Embarcar")
                        Spacer()
                    }
                 })
            }
            .padding(16)
            
            Spacer()
            Spacer()
            Spacer()
            Spacer()
        }
        .navigationTitle("Embarcar")
    }
}

struct GetInPage_Previews: PreviewProvider {
    static var previews: some View {
        GetInPage()
    }
}
